package com.pogreb.main_page.presentation.state

import com.pogreb.main_page.domain.entity.Loan
import com.pogreb.main_page.domain.entity.LoanConditions

interface MainPageState {
    data object Initialize : MainPageState

    data object Loading : MainPageState

    data class Content(
        val loanConditions: LoanConditions,
        val errorTextConditions: String,
        val loans: List<Loan>,
        val errorTextLoans: String,
        val loanAmount: Long,
    ) : MainPageState
}