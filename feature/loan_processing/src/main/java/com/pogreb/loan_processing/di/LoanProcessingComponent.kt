package com.pogreb.loan_processing.di

import com.pogreb.loan_processing.presentation.LoanProcessingRouter
import com.pogreb.loan_processing.presentation.ui.fragment.LoanProcessingFragment
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Inject

@Component(
    modules = [
        LoanProcessingModule::class,
    ],
    dependencies = [
        LoanProcessingComponent.Dependencies::class,
    ],
)
interface LoanProcessingComponent {
    fun inject(target: LoanProcessingFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder

        fun build(): LoanProcessingComponent
    }

    class Dependencies @Inject constructor(
        val retrofit: Retrofit,
        val router: LoanProcessingRouter,
    )
}