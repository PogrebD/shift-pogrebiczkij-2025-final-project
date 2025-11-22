package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.converter.LoanRequestConverter
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.datasource.RemoteLoanProcessingDataSource
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanData
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanResult
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.UserData
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.repository.LoanProcessingRepository
import javax.inject.Inject

class LoanProcessingRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteLoanProcessingDataSource,
    private val converter: LoanRequestConverter
) : LoanProcessingRepository {

    override suspend fun createNewLoan(
        loanData: LoanData,
        userData: UserData,
    ): LoanResult {
        val loanResult = remoteDataSource.createNewLoan(
            converter.convertToLoanRequest(
                loanData = loanData,
                userData = userData
            )
        )
        return loanResult
    }
}