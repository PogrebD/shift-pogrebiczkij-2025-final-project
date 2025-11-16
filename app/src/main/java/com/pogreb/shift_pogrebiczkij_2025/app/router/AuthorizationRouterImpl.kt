package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.AuthorizationRouter

class AuthorizationRouterImpl : AuthorizationRouter {
    override fun openOnboarding(fragmentManager: FragmentManager) {
        /*fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                OnBoardingFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()*/
    }

    override fun openMainPage(fragmentManager: FragmentManager) {
        TODO("Not yet implemented")
    }
}