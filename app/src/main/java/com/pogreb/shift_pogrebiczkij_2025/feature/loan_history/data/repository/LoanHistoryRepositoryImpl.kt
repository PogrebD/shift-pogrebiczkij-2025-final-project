package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.data.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.data.datasource.RemoteLoanHistoryDataSource
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.entity.Loan
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.repository.LoanHistoryRepository
import javax.inject.Inject

class LoanHistoryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteLoanHistoryDataSource,
) : LoanHistoryRepository {
    override suspend fun getAllLoans(): List<Loan> =
        remoteDataSource.getAllLoans()
}