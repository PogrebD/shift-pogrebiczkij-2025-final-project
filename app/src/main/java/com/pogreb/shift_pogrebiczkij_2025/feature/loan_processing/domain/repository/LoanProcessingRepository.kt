package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanData
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.UserData

interface LoanProcessingRepository {
    suspend fun createNewLoan(loanData: LoanData, userData: UserData): String
}