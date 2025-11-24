package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.authorization.presentation.ui.fragment.AuthorizationFragment
import com.pogreb.bank_addresses.presentation.ui.fragment.BankAddressesFragment
import com.pogreb.loan_history.presentation.ui.fragment.LoanHistoryFragment
import com.pogreb.menu.presentation.MenuRouter
import com.pogreb.menu.presentation.ui.fragment.LanguageFragment
import com.pogreb.menu.presentation.ui.fragment.OffersFragment
import com.pogreb.menu.presentation.ui.fragment.SupportFragment
import com.pogreb.onboarding.presentation.ui.fragment.OnboardingFragment
import com.pogreb.shift_pogrebiczkij_2025.R
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

        fragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_view,
                AuthorizationFragment.newInstance()
            )
            .commit()

        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun openSupport(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                SupportFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun openOffers(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                OffersFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun openLanguage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                LanguageFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }
}