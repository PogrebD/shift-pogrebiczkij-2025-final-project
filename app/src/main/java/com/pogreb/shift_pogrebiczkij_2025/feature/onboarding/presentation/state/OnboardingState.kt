package com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.state

interface OnboardingState {
    data object Initialize : OnboardingState

    data class Content(
        val pageNumber: Int
    ) : OnboardingState
}