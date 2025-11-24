package com.pogreb.loan_processing.domain.repository

import com.pogreb.loan_processing.domain.entity.LoanData
import com.pogreb.loan_processing.domain.entity.LoanResult
import com.pogreb.loan_processing.domain.entity.UserData

interface LoanProcessingRepository {
    suspend fun createNewLoan(loanData: LoanData, userData: UserData): LoanResult
}