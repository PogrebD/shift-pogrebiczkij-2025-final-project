package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.OnboardingRouter
import javax.inject.Inject

class OnboardingRouterImpl @Inject constructor() : OnboardingRouter {
    override fun openPreviousPage(fragmentManager: FragmentManager) {
        fragmentManager.popBackStack()
    }
}