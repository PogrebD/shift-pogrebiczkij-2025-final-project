package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.di.LoanProcessingComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.di.LoanProcessingComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di.MainPageComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di.MainPageComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di.OnboardingComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di.OnboardingComponentProvider

interface ComponentProvider :
    AuthorizationComponentProvider,
    OnboardingComponentProvider,
    MainPageComponentProvider,
    LoanProcessingComponentProvider {
    override fun provideAuthorizationComponent(): AuthorizationComponent
    override fun provideOnboardingComponent(): OnboardingComponent
    override fun provideMainPageComponent(): MainPageComponent
    override fun provideLoanProcessingComponent(): LoanProcessingComponent
}