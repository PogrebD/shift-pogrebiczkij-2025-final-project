package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.state

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.entity.Loan


interface LoanHistoryState {
    data object Initialize : LoanHistoryState

    data object Loading : LoanHistoryState

    data class Content(
        val loans: List<Loan>,
        val isRefreshing: Boolean = false,
        val errorMassage: String = "",
    ) : LoanHistoryState
}