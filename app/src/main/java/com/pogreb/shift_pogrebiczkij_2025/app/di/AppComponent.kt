package com.pogreb.shift_pogrebiczkij_2025.app.di

import android.content.Context
import com.pogreb.authorization.di.AuthorizationComponent
import com.pogreb.bank_addresses.di.BankAddressesComponent
import com.pogreb.loan_details.di.LoanDetailsComponent
import com.pogreb.loan_history.di.LoanHistoryComponent
import com.pogreb.loan_processing.di.LoanProcessingComponent
import com.pogreb.main_page.di.MainPageComponent
import com.pogreb.menu.di.MenuComponent
import com.pogreb.onboarding.di.OnboardingComponent
import com.pogreb.shift_pogrebiczkij_2025.app.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(target: MainActivity)

    fun authorizationComponent(): AuthorizationComponent
    fun onboardingComponent(): OnboardingComponent
    fun mainPageComponent(): MainPageComponent
    fun loanProcessingComponent(): LoanProcessingComponent
    fun bankAddressesComponent(): BankAddressesComponent
    fun loanHistoryComponent(): LoanHistoryComponent
    fun loanDetailsComponent(): LoanDetailsComponent
    fun menuComponent(): MenuComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}