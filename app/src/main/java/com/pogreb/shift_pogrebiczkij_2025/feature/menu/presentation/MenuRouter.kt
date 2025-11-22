package com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation

import androidx.fragment.app.FragmentManager

interface MenuRouter {
    fun openOnboarding(fragmentManager: FragmentManager)
    fun openLoansHistory(fragmentManager: FragmentManager)
    fun openBankAddresses(fragmentManager: FragmentManager)
    fun openAuthorization(fragmentManager: FragmentManager)
    fun openPreviousPage(fragmentManager: FragmentManager)
}