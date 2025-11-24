package com.pogreb.shift_pogrebiczkij_2025.app.router

import androidx.fragment.app.FragmentManager
import com.pogreb.loan_details.presentation.LoanDetailsRouter
import javax.inject.Inject

class LoanDetailsRouterImpl @Inject constructor() : LoanDetailsRouter {
    override fun openPreviousPage(fragmentManager: FragmentManager) {
        fragmentManager.popBackStack()
    }
}