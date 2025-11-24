package com.pogreb.loan_history.data.repository

import com.pogreb.loan_history.data.converter.LoanModelConverter
import com.pogreb.loan_history.data.datasource.RemoteLoanHistoryDataSource
import com.pogreb.loan_history.domain.entity.Loan
import com.pogreb.loan_history.domain.repository.LoanHistoryRepository
import javax.inject.Inject

class LoanHistoryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteLoanHistoryDataSource,
    private val converter: LoanModelConverter,
) : LoanHistoryRepository {
    override suspend fun getAllLoans(): List<Loan> =
        remoteDataSource.getAllLoans()
            .map { converter.convertFromLoanModel(it) }
}