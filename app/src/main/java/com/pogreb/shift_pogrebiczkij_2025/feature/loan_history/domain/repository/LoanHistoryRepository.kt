package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.Loan

interface LoanHistoryRepository {

    suspend fun getAllLoans(): List<Loan>
}