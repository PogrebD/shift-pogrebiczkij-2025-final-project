package com.pogreb.core.network

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
interface NetworkModule {

    companion object {

        private const val BASE_URL =
            "https://shift-courses-result.yc.ftc.ru/"
        private const val CONNECT_TIMEOUT = 10L
        private const val WRITE_TIMEOUT = 10L
        private const val READ_TIMEOUT = 10L

        val jsonMediaType = "application/json".toMediaType()

        private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        @Provides
        @Named("AuthClient")
        fun provideAuthOkHttpClient(
            @ErrorInterceptorQualifier errorInterceptor: Interceptor,
            @AuthInterceptorQualifier authInterceptor: Interceptor
        ): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(errorInterceptor)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build()

        @Provides
        fun provideJson(): Json = Json { ignoreUnknownKeys = true }

        @Provides
        fun provideJsonConverterFactory(json: Json): Converter.Factory =
            json.asConverterFactory(jsonMediaType)

        @Provides
        fun provideAuthRetrofit(
            converterFactory: Converter.Factory,
            @Named("AuthClient") client: OkHttpClient,
        ): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(converterFactory)
                .client(client)
                .build()
    }

    @Binds
    @ErrorInterceptorQualifier
    fun bindErrorInterceptor(impl: ErrorInterceptor): Interceptor

    @Binds
    @AuthInterceptorQualifier
    fun bindAuthInterceptor(impl: AuthInterceptor): Interceptor
}