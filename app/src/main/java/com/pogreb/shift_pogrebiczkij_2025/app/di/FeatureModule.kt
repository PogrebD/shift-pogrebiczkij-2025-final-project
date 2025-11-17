package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.DaggerAuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di.DaggerOnboardingComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di.OnboardingComponent
import dagger.Module
import dagger.Provides

@Module
class FeatureModule {

    @Provides
    fun provideAuthorizationComponent(dependencies: AuthorizationComponent.Dependencies): AuthorizationComponent =
        DaggerAuthorizationComponent.builder().dependencies(dependencies).build()

    @Provides
    fun provideOnboardingComponent(dependencies: OnboardingComponent.Dependencies): OnboardingComponent =
        DaggerOnboardingComponent.builder().dependencies(dependencies).build()
}