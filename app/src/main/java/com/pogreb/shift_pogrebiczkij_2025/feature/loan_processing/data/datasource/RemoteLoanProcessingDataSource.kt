package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.datasource

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.model.LoanRequest
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanResult
import javax.inject.Inject

class RemoteLoanProcessingDataSource @Inject constructor(
    private val api: LoanProcessingApi
) {
    suspend fun createNewLoan(loanRequest: LoanRequest): LoanResult =
        api.createNewLoan(loanRequest)
}