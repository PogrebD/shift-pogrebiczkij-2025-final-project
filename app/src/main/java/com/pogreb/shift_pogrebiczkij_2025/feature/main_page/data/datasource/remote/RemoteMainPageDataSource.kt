package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.data.datasource.remote

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.data.model.LoanModel
import javax.inject.Inject

class RemoteMainPageDataSource @Inject constructor(
    private val api: MainPageApi,
) {
    suspend fun getAllLoans(): List<LoanModel> =
        api.getAllLoans()

    suspend fun getLoanConditions() =
        api.getLoanConditions()
}