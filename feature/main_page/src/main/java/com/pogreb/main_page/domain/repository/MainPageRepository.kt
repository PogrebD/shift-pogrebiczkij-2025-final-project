package com.pogreb.main_page.domain.repository

import com.pogreb.main_page.domain.entity.Loan
import com.pogreb.main_page.domain.entity.LoanConditions

interface MainPageRepository {

    suspend fun getAllLoans(): List<Loan>
    suspend fun getLoanConditions(): LoanConditions
}