package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.bank_addresses.presentation.ui.fragment.BankAddressesFragment
import com.pogreb.loan_processing.presentation.LoanProcessingRouter
import com.pogreb.main_page.presentation.ui.fragment.MainPageFragment
import com.pogreb.shift_pogrebiczkij_2025.R
import javax.inject.Inject

class LoanProcessingRouterImpl @Inject constructor() : LoanProcessingRouter {
    override fun openMainPage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_view,
                MainPageFragment.newInstance()
            )
            .commit()
    }

    override fun openBankAddresses(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_view,
                BankAddressesFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }
}