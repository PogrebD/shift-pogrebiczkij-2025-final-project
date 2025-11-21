package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.state

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.Loan

interface LoanHistoryState {
    data object Initialize : LoanHistoryState

    data object Loading : LoanHistoryState

    data class Content(
        val loans: List<Loan>,
    ) : LoanHistoryState

    data class Error(
        val massage: String
    ) : LoanHistoryState
}