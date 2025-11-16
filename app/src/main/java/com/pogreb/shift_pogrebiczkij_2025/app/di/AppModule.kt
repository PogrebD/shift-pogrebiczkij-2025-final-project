package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.core.di.CoreModule
import dagger.Module

@Module(
    includes = [
        CoreModule::class,
        FeatureModule::class,
    ]
)
interface AppModule