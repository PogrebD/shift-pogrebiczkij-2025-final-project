package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.authorization.presentation.AuthorizationRouter
import com.pogreb.main_page.presentation.ui.fragment.MainPageFragment
import com.pogreb.onboarding.presentation.ui.fragment.OnboardingFragment
import com.pogreb.shift_pogrebiczkij_2025.R
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

        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        fragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_view,
                MainPageFragment.newInstance(),
            )
            .commit()

        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                OnboardingFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun openMainPage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                OnboardingFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()

        fragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_view,
                MainPageFragment.newInstance(),
            )
            .commit()

        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}