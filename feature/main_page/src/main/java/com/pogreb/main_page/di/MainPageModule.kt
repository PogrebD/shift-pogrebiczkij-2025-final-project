package com.pogreb.main_page.di

import androidx.lifecycle.ViewModelProvider
import com.pogreb.main_page.data.datasource.remote.MainPageApi
import com.pogreb.main_page.data.datasource.remote.RemoteMainPageDataSource
import com.pogreb.main_page.data.repository.MainPageRepositoryImpl
import com.pogreb.main_page.domain.repository.MainPageRepository
import com.pogreb.main_page.presentation.viewmodel.MainPageViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface MainPageModule {

    companion object {

        @Provides
        fun provideMainPageApi(retrofit: Retrofit) =
            retrofit.create(MainPageApi::class.java)


        @Provides
        fun provideRemoteMainPageDataSource(api: MainPageApi): RemoteMainPageDataSource =
            RemoteMainPageDataSource(api)
    }

    @Binds
    fun bindViewModelFactory(factory: MainPageViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindMainPageRepository(impl: MainPageRepositoryImpl): MainPageRepository
}