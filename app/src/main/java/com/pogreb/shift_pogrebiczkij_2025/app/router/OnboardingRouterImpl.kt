package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.fragment.MainPageFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.OnboardingRouter
import javax.inject.Inject

class OnboardingRouterImpl @Inject constructor() : OnboardingRouter {
    override fun openMainPage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                MainPageFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }
}