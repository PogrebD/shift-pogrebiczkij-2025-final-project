package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.state

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.entity.LoanDetails

interface LoanDetailsState {
    data object Initialize : LoanDetailsState

    data object Loading : LoanDetailsState

    data class Content(
        val loanDetails: LoanDetails,
    ) : LoanDetailsState

    data class Error(
        val massage: String
    ) : LoanDetailsState
}