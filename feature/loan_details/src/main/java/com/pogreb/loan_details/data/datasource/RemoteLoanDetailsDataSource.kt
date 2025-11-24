package com.pogreb.loan_details.data.datasource

import com.pogreb.loan_details.data.model.LoanDetailsModel
import javax.inject.Inject

class RemoteLoanDetailsDataSource @Inject constructor(
    private val api: LoanDetailsApi,
) {
    suspend fun getLoanDetails(id: Long): LoanDetailsModel =
        api.getLoanDetails(id)
}