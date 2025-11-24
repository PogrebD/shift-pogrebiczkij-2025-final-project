package com.pogreb.loan_history.domain.repository

import com.pogreb.loan_history.domain.entity.Loan

interface LoanHistoryRepository {

    suspend fun getAllLoans(): List<Loan>
}