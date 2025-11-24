package com.pogreb.main_page.presentation

import androidx.fragment.app.FragmentManager

interface MainPageRouter {
    fun openOnboarding(fragmentManager: FragmentManager)
    fun openLoansHistory(fragmentManager: FragmentManager)
    fun openLoanDetails(
        fragmentManager: FragmentManager,
        id: Long
    )
    fun openLoanProcessing(
        fragmentManager: FragmentManager,
        percent: Double,
        period: Int,
        amount: Long
    )
}