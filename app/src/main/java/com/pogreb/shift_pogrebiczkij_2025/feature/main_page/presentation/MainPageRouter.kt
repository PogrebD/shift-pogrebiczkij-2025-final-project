package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation

import androidx.fragment.app.FragmentManager

interface MainPageRouter {
    fun openOnboarding(fragmentManager: FragmentManager)
    fun openLoansHistory(fragmentManager: FragmentManager)
    fun openMenu(fragmentManager: FragmentManager)
    fun openLoanProcessing(fragmentManager: FragmentManager)
}