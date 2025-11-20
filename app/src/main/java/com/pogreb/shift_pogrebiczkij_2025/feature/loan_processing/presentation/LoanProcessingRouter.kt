package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation

import androidx.fragment.app.FragmentManager

interface LoanProcessingRouter {
    fun openMainPage(fragmentManager: FragmentManager)
    fun openBankAddresses(fragmentManager: FragmentManager)
}