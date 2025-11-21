package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.di.BankAddressesComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.di.BankAddressesComponentProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.di.LoanHistoryComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.di.LoanHistoryComponentProvider
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
    LoanProcessingComponentProvider,
    BankAddressesComponentProvider,
    LoanHistoryComponentProvider {
    override fun provideAuthorizationComponent(): AuthorizationComponent
    override fun provideOnboardingComponent(): OnboardingComponent
    override fun provideMainPageComponent(): MainPageComponent
    override fun provideLoanProcessingComponent(): LoanProcessingComponent
    override fun provideBankAddressesComponent(): BankAddressesComponent
    override fun provideLoanHistoryComponent(): LoanHistoryComponent
}