package com.pogreb.shift_pogrebiczkij_2025.core.di

import com.pogreb.shift_pogrebiczkij_2025.core.network.NetworkModule
import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
    ]
)
interface CoreModule