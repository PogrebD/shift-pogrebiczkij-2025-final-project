package com.pogreb.loan_details.data.repository

import com.pogreb.loan_details.data.converter.LoanDetailsModelConverter
import com.pogreb.loan_details.data.datasource.RemoteLoanDetailsDataSource
import com.pogreb.loan_details.domain.entity.LoanDetails
import com.pogreb.loan_details.domain.repository.LoanDetailsRepository
import javax.inject.Inject

class LoanDetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteLoanDetailsDataSource,
    private val converter: LoanDetailsModelConverter,
) : LoanDetailsRepository {
    override suspend fun getLoanDetails(id: Long): LoanDetails =
        converter.convertFromLoanDetailsModel(
            remoteDataSource.getLoanDetails(id)
        )
}