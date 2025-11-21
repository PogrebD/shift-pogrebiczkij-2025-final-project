package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.datasource.RemoteLoanDetailsDataSource
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.entity.LoanDetails
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.repository.LoanDetailsRepository
import javax.inject.Inject

class LoanDetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteLoanDetailsDataSource,
) : LoanDetailsRepository {
    override suspend fun getLoanDetails(id: Long): LoanDetails =
        remoteDataSource.getLoanDetails(id)
}