package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation

import androidx.fragment.app.FragmentManager

interface AuthorizationRouter {
    fun openOnboarding(fragmentManager: FragmentManager)
    fun openMainPage(fragmentManager: FragmentManager)
}