package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.data.datasource

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.entity.Loan
import javax.inject.Inject

class RemoteLoanHistoryDataSource @Inject constructor(
    private val api: LoanHistoryApi,
) {
    suspend fun getAllLoans(): List<Loan> =
        api.getAllLoans()
}