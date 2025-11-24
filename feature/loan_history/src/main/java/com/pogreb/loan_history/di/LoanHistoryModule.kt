package com.pogreb.loan_history.di

import androidx.lifecycle.ViewModelProvider
import com.pogreb.loan_history.data.datasource.LoanHistoryApi
import com.pogreb.loan_history.data.datasource.RemoteLoanHistoryDataSource
import com.pogreb.loan_history.data.repository.LoanHistoryRepositoryImpl
import com.pogreb.loan_history.domain.repository.LoanHistoryRepository
import com.pogreb.loan_history.presentation.viewmodel.LoanHistoryViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface LoanHistoryModule {

    companion object {

        @Provides
        fun provideLoanHistoryApi(retrofit: Retrofit) =
            retrofit.create(LoanHistoryApi::class.java)

        @Provides
        fun provideRemoteLoanHistoryDataSource(api: LoanHistoryApi): RemoteLoanHistoryDataSource =
            RemoteLoanHistoryDataSource(api)
    }

    @Binds
    fun bindViewModelFactory(factory: LoanHistoryViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindLoanHistoryRepository(impl: LoanHistoryRepositoryImpl): LoanHistoryRepository
}