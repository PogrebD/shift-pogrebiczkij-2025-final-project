package com.pogreb.loan_history.data.datasource

import com.pogreb.loan_history.data.model.LoanModel
import javax.inject.Inject

class RemoteLoanHistoryDataSource @Inject constructor(
    private val api: LoanHistoryApi,
) {
    suspend fun getAllLoans(): List<LoanModel> =
        api.getAllLoans()
}