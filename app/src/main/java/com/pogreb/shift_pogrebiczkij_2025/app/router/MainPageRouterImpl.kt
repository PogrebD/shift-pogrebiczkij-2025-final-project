package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.MainPageRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.fragment.OnboardingFragment
import javax.inject.Inject

class MainPageRouterImpl @Inject constructor() : MainPageRouter {
    override fun openOnboarding(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                OnboardingFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun openLoansHistory(fragmentManager: FragmentManager) {
        TODO("Not yet implemented")
    }

    override fun openMenu(fragmentManager: FragmentManager) {
        TODO("Not yet implemented")
    }

    override fun openLoanProcessing(fragmentManager: FragmentManager) {
        TODO("Not yet implemented")
    }
}