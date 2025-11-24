package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.loan_details.presentation.ui.fragment.LoanDetailsFragment
import com.pogreb.loan_history.presentation.ui.fragment.LoanHistoryFragment
import com.pogreb.loan_processing.presentation.ui.fragment.LoanProcessingFragment
import com.pogreb.main_page.presentation.MainPageRouter
import com.pogreb.onboarding.presentation.ui.fragment.OnboardingFragment
import com.pogreb.shift_pogrebiczkij_2025.R
import javax.inject.Inject

class MainPageRouterImpl @Inject constructor() : MainPageRouter {
    override fun openOnboarding(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                OnboardingFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun openLoansHistory(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                LoanHistoryFragment.newInstance()
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

    override fun openLoanProcessing(
        fragmentManager: FragmentManager,
        percent: Double,
        period: Int,
        amount: Long
    ) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                LoanProcessingFragment.newInstance(
                    percent = percent,
                    period = period,
                    amount = amount,
                )
            )
            .addToBackStack(null)
            .commit()
    }
}