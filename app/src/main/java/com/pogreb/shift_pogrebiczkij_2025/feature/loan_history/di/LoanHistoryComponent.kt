package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.di

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.LoanHistoryRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.ui.fragment.LoanHistoryFragment
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Inject

@Component(
    modules = [
        LoanHistoryModule::class,
    ],
    dependencies = [
        LoanHistoryComponent.Dependencies::class
    ]
)
interface LoanHistoryComponent {
    fun inject(target: LoanHistoryFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder

        fun build(): LoanHistoryComponent
    }

    class Dependencies @Inject constructor(
        val retrofit: Retrofit,
        val router: LoanHistoryRouter,
    )
}