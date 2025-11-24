package com.pogreb.core.network

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface TokenModule {

    companion object {
        @Singleton
        @Provides
        fun provideTokenManager(context: Context): TokenManager =
            TokenManager(context)
    }
}