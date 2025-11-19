package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.state

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanData
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.UserData
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType

interface LoanProcessingState {
    data object Initialize : LoanProcessingState

    data class Content(
        val loanData: LoanData,
        val userData: UserData,
        val nameErrorType: InputErrorType,
        val lastNameErrorType: InputErrorType,
    ) : LoanProcessingState

    data class SuccessfulResult(
        val amount: Long,
        val date: String,
    ) : LoanProcessingState

    data object FailureResult : LoanProcessingState
}