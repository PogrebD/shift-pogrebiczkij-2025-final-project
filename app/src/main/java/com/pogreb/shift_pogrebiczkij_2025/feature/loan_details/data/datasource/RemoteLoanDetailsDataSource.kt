package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.datasource

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.entity.LoanDetails
import javax.inject.Inject

class RemoteLoanDetailsDataSource @Inject constructor(
    private val api: LoanDetailsApi,
) {
    suspend fun getLoanDetails(id: Long): LoanDetails =
        api.getLoanDetails(id)
}