package com.pogreb.shift_pogrebiczkij_2025.core.network

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
import java.util.concurrent.TimeUnit

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
        fun provideOkHttpClient(errorInterceptor: Interceptor): OkHttpClient =
            OkHttpClient.Builder()
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
        fun provideRetrofit(
            converterFactory: Converter.Factory,
            client: OkHttpClient,
        ): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build()
    }

    @Binds
    fun bindErrorInterceptor(impl: ErrorInterceptor): Interceptor
}