package com.pogreb.shift_pogrebiczkij_2025.app.di

import android.content.Context
import com.pogreb.shift_pogrebiczkij_2025.app.MainActivity
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.di.BankAddressesComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.di.LoanDetailsComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.di.LoanHistoryComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.di.LoanProcessingComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.di.MainPageComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di.OnboardingComponent
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

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}