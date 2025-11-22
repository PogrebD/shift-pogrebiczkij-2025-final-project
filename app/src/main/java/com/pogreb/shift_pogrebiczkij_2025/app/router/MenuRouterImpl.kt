package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.fragment.AuthorizationFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.ui.fragment.BankAddressesFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.ui.fragment.LoanHistoryFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.MenuRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.ui.fragment.MenuFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.fragment.OnboardingFragment
import javax.inject.Inject

class MenuRouterImpl @Inject constructor() : MenuRouter {
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

    override fun openBankAddresses(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                BankAddressesFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun openAuthorization(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                AuthorizationFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun openPreviousPage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                MenuFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    } // временно
}