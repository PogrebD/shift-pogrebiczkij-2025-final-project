package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.DaggerAuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.di.DaggerLoanProcessingComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.di.LoanProcessingComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di.DaggerMainPageComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di.MainPageComponent
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

    @Provides
    fun provideMainPageComponent(dependencies: MainPageComponent.Dependencies): MainPageComponent =
        DaggerMainPageComponent.builder().dependencies(dependencies).build()

    @Provides
    fun provideLoanProcessingComponent(dependencies: LoanProcessingComponent.Dependencies): LoanProcessingComponent =
        DaggerLoanProcessingComponent.builder().dependencies(dependencies).build()
}