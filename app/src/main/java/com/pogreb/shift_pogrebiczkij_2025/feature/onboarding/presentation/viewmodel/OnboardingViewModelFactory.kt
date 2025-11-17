package com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class OnboardingViewModelFactory @Inject constructor(
    private val viewModelProvider: Provider<OnboardingViewModel>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OnboardingViewModel::class.java)) {
            return viewModelProvider.get() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
    }
}