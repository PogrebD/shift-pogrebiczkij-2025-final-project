package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.entity.LoanDetails

interface LoanDetailsRepository {
    suspend fun getLoanDetails(id: Long): LoanDetails
}