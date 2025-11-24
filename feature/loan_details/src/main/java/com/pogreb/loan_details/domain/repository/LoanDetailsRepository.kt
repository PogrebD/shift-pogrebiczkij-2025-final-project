package com.pogreb.loan_details.domain.repository

import com.pogreb.loan_details.domain.entity.LoanDetails

interface LoanDetailsRepository {
    suspend fun getLoanDetails(id: Long): LoanDetails
}