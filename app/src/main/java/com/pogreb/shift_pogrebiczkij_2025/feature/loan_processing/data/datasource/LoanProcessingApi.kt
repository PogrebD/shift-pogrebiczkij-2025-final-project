package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.datasource

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.entity.LoanRequest
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.data.entity.LoanResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoanProcessingApi {

    @POST("loans")
    suspend fun createNewLoan(@Body loanRequest: LoanRequest): LoanResponse
}