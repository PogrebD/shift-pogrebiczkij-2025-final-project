package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.AuthorizationRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.fragment.OnboardingFragment
import javax.inject.Inject

class AuthorizationRouterImpl @Inject constructor() : AuthorizationRouter {
    override fun openOnboarding(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                OnboardingFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun openMainPage(fragmentManager: FragmentManager) {
        TODO("Not yet implemented")
    }
}