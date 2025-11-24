package com.pogreb.loan_processing.data.datasource

import com.pogreb.loan_processing.data.model.LoanRequest
import com.pogreb.loan_processing.domain.entity.LoanResult
import retrofit2.http.Body
import retrofit2.http.POST

interface LoanProcessingApi {
    @POST("loans")
    suspend fun createNewLoan(@Body loanRequest: LoanRequest): LoanResult
}