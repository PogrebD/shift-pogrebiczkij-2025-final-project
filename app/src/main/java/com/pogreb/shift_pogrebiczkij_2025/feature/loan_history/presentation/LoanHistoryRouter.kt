package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation

import androidx.fragment.app.FragmentManager

interface LoanHistoryRouter {
    fun openPreviousPage(fragmentManager: FragmentManager)
    fun openLoanDetails(
        fragmentManager: FragmentManager,
        id: Long
    )
}