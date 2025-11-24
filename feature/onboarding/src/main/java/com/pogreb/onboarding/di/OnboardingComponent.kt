package com.pogreb.onboarding.di

import com.pogreb.onboarding.presentation.OnboardingRouter
import com.pogreb.onboarding.presentation.ui.fragment.OnboardingFragment
import dagger.Component
import javax.inject.Inject

@Component(
    modules = [
        OnboardingModule::class,
    ],
    dependencies = [
        OnboardingComponent.Dependencies::class
    ]
)
interface OnboardingComponent {
    fun inject(target: OnboardingFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder

        fun build(): OnboardingComponent
    }

    class Dependencies @Inject constructor(
        val router: OnboardingRouter,
    )
}