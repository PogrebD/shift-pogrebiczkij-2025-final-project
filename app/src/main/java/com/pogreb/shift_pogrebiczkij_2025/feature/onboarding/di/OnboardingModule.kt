package com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.di

import androidx.lifecycle.ViewModelProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.viewmodel.OnboardingViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface OnboardingModule {

    @Binds
    fun bindViewModelFactory(factory: OnboardingViewModelFactory): ViewModelProvider.Factory
}