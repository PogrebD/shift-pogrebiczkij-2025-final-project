package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.state

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.entity.Loan


interface LoanHistoryState {
    data object Initialize : LoanHistoryState

    data object Loading : LoanHistoryState

    data class Content(
        val loans: List<Loan>,
        val isRefreshing: Boolean,
    ) : LoanHistoryState

    data class Error(
        val massage: String,
        val isRefreshing: Boolean,
    ) : LoanHistoryState
}