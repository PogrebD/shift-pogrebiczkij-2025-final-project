package com.pogreb.authorization.di

import androidx.lifecycle.ViewModelProvider
import com.pogreb.authorization.data.datasource.remote.AuthorizationApi
import com.pogreb.authorization.data.datasource.remote.RemoteAuthorizationDataSource
import com.pogreb.authorization.data.repository.AuthorizationRepositoryImpl
import com.pogreb.authorization.domain.repository.AuthorizationRepository
import com.pogreb.authorization.presentation.viewmodel.AuthorizationViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface AuthorizationModule {

    companion object {

        @Provides
        fun provideAuthorizationApi(retrofit: Retrofit) =
            retrofit.create(AuthorizationApi::class.java)


        @Provides
        fun provideRemoteAuthorizationDataSource(api: AuthorizationApi): RemoteAuthorizationDataSource =
            RemoteAuthorizationDataSource(api)
    }

    @Binds
    fun bindViewModelFactory(factory: AuthorizationViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindAuthorizationRepository(impl: AuthorizationRepositoryImpl): AuthorizationRepository
}