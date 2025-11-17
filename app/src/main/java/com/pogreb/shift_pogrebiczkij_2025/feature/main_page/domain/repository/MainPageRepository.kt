package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.Loan
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.LoanConditions

interface MainPageRepository {

    suspend fun getLoanConditions(): LoanConditions
    suspend fun getLoans(): List<Loan>
}