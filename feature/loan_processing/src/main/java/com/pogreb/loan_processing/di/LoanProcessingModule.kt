package com.pogreb.loan_processing.di

import androidx.lifecycle.ViewModelProvider
import com.pogreb.loan_processing.data.converter.LoanRequestConverter
import com.pogreb.loan_processing.data.datasource.LoanProcessingApi
import com.pogreb.loan_processing.data.datasource.RemoteLoanProcessingDataSource
import com.pogreb.loan_processing.data.repository.LoanProcessingRepositoryImpl
import com.pogreb.loan_processing.domain.repository.LoanProcessingRepository
import com.pogreb.loan_processing.presentation.viewmodel.LoanProcessingViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface LoanProcessingModule {

    companion object {

        @Provides
        fun provideLoanProcessingApi(retrofit: Retrofit) =
            retrofit.create(LoanProcessingApi::class.java)

        @Provides
        fun provideLoanRequestConverter() =
            LoanRequestConverter()

        @Provides
        fun provideRemoteLoanProcessingDataSource(api: LoanProcessingApi): RemoteLoanProcessingDataSource =
            RemoteLoanProcessingDataSource(api)
    }

    @Binds
    fun bindViewModelFactory(factory: LoanProcessingViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindLoanProcessingRepository(impl: LoanProcessingRepositoryImpl): LoanProcessingRepository
}