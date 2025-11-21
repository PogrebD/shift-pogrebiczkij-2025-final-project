package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.data.datasource

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.entity.Loan
import retrofit2.http.GET

interface LoanHistoryApi {

    @GET("loans/all")
    suspend fun getAllLoans(): List<Loan>

}