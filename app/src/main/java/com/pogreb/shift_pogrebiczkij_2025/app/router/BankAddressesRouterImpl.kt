package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.bank_addresses.presentation.BankAddressesRouter
import com.pogreb.main_page.presentation.ui.fragment.MainPageFragment
import com.pogreb.shift_pogrebiczkij_2025.R
import javax.inject.Inject

class BankAddressesRouterImpl @Inject constructor() : BankAddressesRouter {
    override fun openMainPage(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_view,
                MainPageFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()

        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}