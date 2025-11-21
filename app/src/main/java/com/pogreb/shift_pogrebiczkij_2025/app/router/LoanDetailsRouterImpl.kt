package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.LoanDetailsRouter
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.fragment.MainPageFragment
import javax.inject.Inject

class LoanDetailsRouterImpl @Inject constructor() : LoanDetailsRouter {
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
        TODO("Not yet implemented")
    }
}