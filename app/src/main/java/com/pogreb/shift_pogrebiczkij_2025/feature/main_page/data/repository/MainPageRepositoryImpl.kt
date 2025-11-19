package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.data.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.data.datasource.remote.RemoteMainPageDataSource
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.Loan
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.LoanConditions
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.repository.MainPageRepository
import javax.inject.Inject

class MainPageRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteMainPageDataSource,
) : MainPageRepository {
    override suspend fun getAllLoans(): List<Loan> =
        remoteDataSource.getAllLoans()


    override suspend fun getLoanConditions(): LoanConditions =
        remoteDataSource.getLoanConditions()
}