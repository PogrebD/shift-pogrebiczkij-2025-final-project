package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.ui.fragment.BankAddressesFragment
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.LoanProcessingRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.fragment.MainPageFragment
import javax.inject.Inject

class LoanProcessingRouterImpl @Inject constructor() : LoanProcessingRouter {
    override fun openMainPage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                MainPageFragment.newInstance()
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
}