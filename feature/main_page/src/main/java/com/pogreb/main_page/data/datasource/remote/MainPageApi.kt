package com.pogreb.main_page.data.datasource.remote

import com.pogreb.main_page.data.model.LoanModel
import com.pogreb.main_page.domain.entity.LoanConditions
import retrofit2.http.GET

interface MainPageApi {
    @GET("loans/all")
    suspend fun getAllLoans(): List<LoanModel>

    @GET("loans/conditions")
    suspend fun getLoanConditions(): LoanConditions
}