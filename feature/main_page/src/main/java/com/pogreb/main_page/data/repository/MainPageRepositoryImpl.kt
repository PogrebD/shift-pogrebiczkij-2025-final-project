package com.pogreb.main_page.data.repository

import com.pogreb.main_page.data.converter.LoanModelConverter
import com.pogreb.main_page.data.datasource.remote.RemoteMainPageDataSource
import com.pogreb.main_page.domain.entity.Loan
import com.pogreb.main_page.domain.entity.LoanConditions
import com.pogreb.main_page.domain.repository.MainPageRepository
import javax.inject.Inject

class MainPageRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteMainPageDataSource,
    private val converter: LoanModelConverter,
) : MainPageRepository {
    override suspend fun getAllLoans(): List<Loan> =
        remoteDataSource.getAllLoans()
            .map { converter.convertFromLoanModel(it) }


    override suspend fun getLoanConditions(): LoanConditions =
        remoteDataSource.getLoanConditions()
}