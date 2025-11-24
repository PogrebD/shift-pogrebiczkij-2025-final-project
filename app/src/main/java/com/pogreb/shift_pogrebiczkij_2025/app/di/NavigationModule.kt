package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.authorization.presentation.AuthorizationRouter
import com.pogreb.bank_addresses.presentation.BankAddressesRouter
import com.pogreb.loan_details.presentation.LoanDetailsRouter
import com.pogreb.loan_history.presentation.LoanHistoryRouter
import com.pogreb.loan_processing.presentation.LoanProcessingRouter
import com.pogreb.main_page.presentation.MainPageRouter
import com.pogreb.menu.presentation.MenuRouter
import com.pogreb.onboarding.presentation.OnboardingRouter
import com.pogreb.shift_pogrebiczkij_2025.app.router.AuthorizationRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.BankAddressesRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.LoanDetailsRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.LoanHistoryRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.LoanProcessingRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.MainPageRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.MenuRouterImpl
import com.pogreb.shift_pogrebiczkij_2025.app.router.OnboardingRouterImpl
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

    @Binds
    fun bindLoanDetailsRouter(impl: LoanDetailsRouterImpl): LoanDetailsRouter

    @Binds
    fun bindMenuRouter(impl: MenuRouterImpl): MenuRouter
}