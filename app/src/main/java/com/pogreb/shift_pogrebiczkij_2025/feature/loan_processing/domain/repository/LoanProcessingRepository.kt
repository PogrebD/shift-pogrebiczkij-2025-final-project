package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanConditions
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.UserData

interface LoanProcessingRepository {
    fun createNewLoan(loanConditions: LoanConditions, userData: UserData): String
}