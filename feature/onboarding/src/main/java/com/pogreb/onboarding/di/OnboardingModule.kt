package com.pogreb.onboarding.di

import androidx.lifecycle.ViewModelProvider
import com.pogreb.onboarding.presentation.viewmodel.OnboardingViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface OnboardingModule {

    @Binds
    fun bindViewModelFactory(factory: OnboardingViewModelFactory): ViewModelProvider.Factory
}