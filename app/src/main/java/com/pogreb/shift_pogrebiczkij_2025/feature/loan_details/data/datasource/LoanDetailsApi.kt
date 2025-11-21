package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.datasource

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.model.LoanDetailsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface LoanDetailsApi {
    @GET("loans/{id}")
    suspend fun getLoanDetails(
        @Path("id") id: Long
    ): LoanDetailsModel
}