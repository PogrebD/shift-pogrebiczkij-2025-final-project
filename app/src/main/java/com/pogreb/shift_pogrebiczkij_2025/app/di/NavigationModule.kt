package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.app.router.AuthorizationRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.OnboardingRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.AuthorizationRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.OnboardingRouter
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindAuthorizationRouter(impl: AuthorizationRouterImpl): AuthorizationRouter

    @Binds
    fun bindOnboardingRouter(impl: OnboardingRouterImpl): OnboardingRouter
}