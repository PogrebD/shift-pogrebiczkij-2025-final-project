package com.pogreb.core.di

import com.pogreb.core.network.NetworkModule
import com.pogreb.core.network.TokenModule
import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        TokenModule::class,
    ]
)
interface CoreModule