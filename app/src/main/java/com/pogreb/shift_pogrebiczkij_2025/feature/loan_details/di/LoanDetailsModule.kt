package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.di

import androidx.lifecycle.ViewModelProvider
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.datasource.LoanDetailsApi
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.datasource.RemoteLoanDetailsDataSource
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.repository.LoanDetailsRepositoryImpl
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.repository.LoanDetailsRepository
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.viewmodel.LoanDetailsViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface LoanDetailsModule {

    companion object {

        @Provides
        fun provideLoanDetailsApi(retrofit: Retrofit) =
            retrofit.create(LoanDetailsApi::class.java)


        @Provides
        fun provideRemoteLoanDetailsDataSource(api: LoanDetailsApi): RemoteLoanDetailsDataSource =
            RemoteLoanDetailsDataSource(api)
    }

    @Binds
    fun bindViewModelFactory(factory: LoanDetailsViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindLoanDetailsRepository(impl: LoanDetailsRepositoryImpl): LoanDetailsRepository
}