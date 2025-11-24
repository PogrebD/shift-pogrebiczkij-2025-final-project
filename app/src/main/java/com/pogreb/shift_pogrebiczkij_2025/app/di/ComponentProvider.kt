package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.authorization.di.AuthorizationComponent
import com.pogreb.authorization.di.AuthorizationComponentProvider
import com.pogreb.bank_addresses.di.BankAddressesComponent
import com.pogreb.bank_addresses.di.BankAddressesComponentProvider
import com.pogreb.loan_details.di.LoanDetailsComponent
import com.pogreb.loan_details.di.LoanDetailsComponentProvider
import com.pogreb.loan_history.di.LoanHistoryComponent
import com.pogreb.loan_history.di.LoanHistoryComponentProvider
import com.pogreb.loan_processing.di.LoanProcessingComponent
import com.pogreb.loan_processing.di.LoanProcessingComponentProvider
import com.pogreb.main_page.di.MainPageComponent
import com.pogreb.main_page.di.MainPageComponentProvider
import com.pogreb.menu.di.MenuComponent
import com.pogreb.menu.di.MenuComponentProvider
import com.pogreb.onboarding.di.OnboardingComponent
import com.pogreb.onboarding.di.OnboardingComponentProvider

interface ComponentProvider :
    AuthorizationComponentProvider,
    OnboardingComponentProvider,
    MainPageComponentProvider,
    LoanProcessingComponentProvider,
    BankAddressesComponentProvider,
    LoanHistoryComponentProvider,
    LoanDetailsComponentProvider,
    MenuComponentProvider {
    override fun provideAuthorizationComponent(): AuthorizationComponent
    override fun provideOnboardingComponent(): OnboardingComponent
    override fun provideMainPageComponent(): MainPageComponent
    override fun provideLoanProcessingComponent(): LoanProcessingComponent
    override fun provideBankAddressesComponent(): BankAddressesComponent
    override fun provideLoanHistoryComponent(): LoanHistoryComponent
    override fun provideLoanDetailsComponent(): LoanDetailsComponent
    override fun provideMenuComponent(): MenuComponent
}