package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.di

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.LoanDetailsRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.ui.fragment.LoanDetailsFragment
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Inject

@Component(
    modules = [
        LoanDetailsModule::class,
    ],
    dependencies = [
        LoanDetailsComponent.Dependencies::class
    ]
)
interface LoanDetailsComponent {
    fun inject(target: LoanDetailsFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder

        fun build(): LoanDetailsComponent
    }

    class Dependencies @Inject constructor(
        val retrofit: Retrofit,
        val router: LoanDetailsRouter,
    )
}