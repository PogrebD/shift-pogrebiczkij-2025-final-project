package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.ui.fragment.LoanDetailsFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.LoanHistoryRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.fragment.MainPageFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.ui.fragment.MenuFragment
import javax.inject.Inject

class LoanHistoryRouterImpl @Inject constructor() : LoanHistoryRouter {
    override fun openPreviousPage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                MainPageFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    } // временно

    override fun openMenu(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                MenuFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
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