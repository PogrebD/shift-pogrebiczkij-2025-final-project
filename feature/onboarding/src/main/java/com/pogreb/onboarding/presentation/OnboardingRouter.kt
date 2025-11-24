package com.pogreb.onboarding.presentation

import androidx.fragment.app.FragmentManager

interface OnboardingRouter {
    fun openPreviousPage(fragmentManager: FragmentManager)
}