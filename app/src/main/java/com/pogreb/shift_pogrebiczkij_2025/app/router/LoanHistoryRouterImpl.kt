package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.loan_details.presentation.ui.fragment.LoanDetailsFragment
import com.pogreb.loan_history.presentation.LoanHistoryRouter
import com.pogreb.shift_pogrebiczkij_2025.R
import javax.inject.Inject

class LoanHistoryRouterImpl @Inject constructor() : LoanHistoryRouter {
    override fun openPreviousPage(fragmentManager: FragmentManager) {
        fragmentManager.popBackStack()
    }

    override fun openLoanDetails(
        fragmentManager: FragmentManager,
        id: Long
    ) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                LoanDetailsFragment.newInstance(
                    loanId = id,
                )
            )
            .addToBackStack(null)
            .commit()
    }
}