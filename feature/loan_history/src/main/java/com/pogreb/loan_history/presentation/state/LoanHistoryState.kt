package com.pogreb.loan_history.presentation.state

import com.pogreb.loan_history.domain.entity.Loan


interface LoanHistoryState {
    data object Initialize : LoanHistoryState

    data object Loading : LoanHistoryState

    data class Content(
        val loans: List<Loan>,
        val isRefreshing: Boolean = false,
        val errorMassage: String = "",
    ) : LoanHistoryState
}