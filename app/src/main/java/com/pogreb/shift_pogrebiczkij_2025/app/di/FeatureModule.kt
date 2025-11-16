package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.DaggerAuthorizationComponent
import dagger.Module
import dagger.Provides

@Module
class FeatureModule {

    @Provides
    fun provideAuthorizationComponent(deps: AuthorizationComponent.Deps): AuthorizationComponent =
        DaggerAuthorizationComponent.builder().deps(deps).build()
}