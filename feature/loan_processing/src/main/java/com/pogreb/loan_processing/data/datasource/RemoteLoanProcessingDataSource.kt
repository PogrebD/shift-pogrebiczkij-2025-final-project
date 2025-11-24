package com.pogreb.loan_processing.data.datasource

import com.pogreb.loan_processing.data.model.LoanRequest
import com.pogreb.loan_processing.domain.entity.LoanResult
import javax.inject.Inject

class RemoteLoanProcessingDataSource @Inject constructor(
    private val api: LoanProcessingApi
) {
    suspend fun createNewLoan(loanRequest: LoanRequest): LoanResult =
        api.createNewLoan(loanRequest)
}