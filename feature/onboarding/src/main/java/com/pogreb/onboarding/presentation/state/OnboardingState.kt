package com.pogreb.onboarding.presentation.state

interface OnboardingState {
    data object Initialize : OnboardingState

    data class Content(
        val pageNumber: Int
    ) : OnboardingState
}