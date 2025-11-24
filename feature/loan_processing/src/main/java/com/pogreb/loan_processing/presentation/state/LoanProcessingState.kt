package com.pogreb.loan_processing.presentation.state

import com.pogreb.design.component.InputErrorType
import com.pogreb.loan_processing.domain.entity.LoanData
import com.pogreb.loan_processing.domain.entity.UserData

interface LoanProcessingState {
    data object Initialize : LoanProcessingState

    data class Content(
        val loanData: LoanData,
        val userData: UserData,
        val nameErrorType: InputErrorType,
        val lastNameErrorType: InputErrorType,
        val phoneErrorType: InputErrorType,
        val errorMassage: String = "",
    ) : LoanProcessingState

    data class SuccessfulResult(
        val amount: Long,
        val date: String,
    ) : LoanProcessingState

    data object FailureResult : LoanProcessingState
}