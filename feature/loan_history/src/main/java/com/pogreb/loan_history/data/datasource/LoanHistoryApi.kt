package com.pogreb.loan_history.data.datasource

import com.pogreb.loan_history.data.model.LoanModel
import retrofit2.http.GET

interface LoanHistoryApi {
    @GET("loans/all")
    suspend fun getAllLoans(): List<LoanModel>
}