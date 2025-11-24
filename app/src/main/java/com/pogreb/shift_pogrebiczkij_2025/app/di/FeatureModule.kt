package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.authorization.di.AuthorizationComponent
import com.pogreb.authorization.di.DaggerAuthorizationComponent
import com.pogreb.bank_addresses.di.BankAddressesComponent
import com.pogreb.bank_addresses.di.DaggerBankAddressesComponent
import com.pogreb.loan_details.di.DaggerLoanDetailsComponent
import com.pogreb.loan_details.di.LoanDetailsComponent
import com.pogreb.loan_history.di.DaggerLoanHistoryComponent
import com.pogreb.loan_history.di.LoanHistoryComponent
import com.pogreb.loan_processing.di.DaggerLoanProcessingComponent
import com.pogreb.loan_processing.di.LoanProcessingComponent
import com.pogreb.main_page.di.DaggerMainPageComponent
import com.pogreb.main_page.di.MainPageComponent
import com.pogreb.menu.di.DaggerMenuComponent
import com.pogreb.menu.di.MenuComponent
import com.pogreb.onboarding.di.DaggerOnboardingComponent
import com.pogreb.onboarding.di.OnboardingComponent
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

    @Provides
    fun provideBankAddressesComponent(dependencies: BankAddressesComponent.Dependencies): BankAddressesComponent =
        DaggerBankAddressesComponent.builder().dependencies(dependencies).build()

    @Provides
    fun provideLoanHistoryComponent(dependencies: LoanHistoryComponent.Dependencies): LoanHistoryComponent =
        DaggerLoanHistoryComponent.builder().dependencies(dependencies).build()

    @Provides
    fun provideLoanDetailsComponent(dependencies: LoanDetailsComponent.Dependencies): LoanDetailsComponent =
        DaggerLoanDetailsComponent.builder().dependencies(dependencies).build()

    @Provides
    fun provideMenuComponent(dependencies: MenuComponent.Dependencies): MenuComponent =
        DaggerMenuComponent.builder().dependencies(dependencies).build()
}