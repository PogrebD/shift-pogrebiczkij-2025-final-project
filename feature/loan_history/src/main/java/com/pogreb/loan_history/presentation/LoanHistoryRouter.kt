package com.pogreb.loan_history.presentation

import androidx.fragment.app.FragmentManager

interface LoanHistoryRouter {
    fun openPreviousPage(fragmentManager: FragmentManager)
    fun openLoanDetails(
        fragmentManager: FragmentManager,
        id: Long
    )
}