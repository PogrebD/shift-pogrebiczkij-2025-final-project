package com.pogreb.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.pogreb.onboarding.presentation.state.OnboardingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class OnboardingViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow<OnboardingState>(OnboardingState.Initialize)
    val state: StateFlow<OnboardingState> = _state.asStateFlow()

    fun initialize() {
        _state.update {
            OnboardingState.Content(
                pageNumber = 0
            )
        }
    }

    fun switchNextPage() {
        var currentPage = (_state.value as OnboardingState.Content).pageNumber
        _state.update {
            OnboardingState.Content(
                pageNumber = ++currentPage
            )
        }
    }

    fun switchPreviousPage() {
        var currentPage = (_state.value as OnboardingState.Content).pageNumber
        _state.update {
            OnboardingState.Content(
                pageNumber = --currentPage
            )
        }
    }
}