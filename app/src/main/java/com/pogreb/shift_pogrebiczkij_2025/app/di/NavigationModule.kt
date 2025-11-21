package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.app.router.AuthorizationRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.BankAddressesRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.LoanHistoryRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.LoanProcessingRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.MainPageRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.OnboardingRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.AuthorizationRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.BankAddressesRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.LoanHistoryRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.LoanProcessingRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.MainPageRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.OnboardingRouter
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindAuthorizationRouter(impl: AuthorizationRouterImpl): AuthorizationRouter

    @Binds
    fun bindOnboardingRouter(impl: OnboardingRouterImpl): OnboardingRouter

    @Binds
    fun bindMainPageRouter(impl: MainPageRouterImpl): MainPageRouter

    @Binds
    fun bindLoanProcessingRouter(impl: LoanProcessingRouterImpl): LoanProcessingRouter

    @Binds
    fun bindBankAddressesRouter(impl: BankAddressesRouterImpl): BankAddressesRouter

    @Binds
    fun bindLoanHistoryRouter(impl: LoanHistoryRouterImpl): LoanHistoryRouter
}