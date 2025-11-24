package com.pogreb.authorization.presentation

import androidx.fragment.app.FragmentManager

interface AuthorizationRouter {
    fun openOnboarding(fragmentManager: FragmentManager)
    fun openMainPage(fragmentManager: FragmentManager)
}