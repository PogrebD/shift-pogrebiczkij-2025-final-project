package com.pogreb.menu.presentation

import androidx.fragment.app.FragmentManager

interface MenuRouter {
    fun openOnboarding(fragmentManager: FragmentManager)
    fun openLoansHistory(fragmentManager: FragmentManager)
    fun openBankAddresses(fragmentManager: FragmentManager)
    fun openAuthorization(fragmentManager: FragmentManager)
    fun openSupport(fragmentManager: FragmentManager)
    fun openOffers(fragmentManager: FragmentManager)
    fun openLanguage(fragmentManager: FragmentManager)
}