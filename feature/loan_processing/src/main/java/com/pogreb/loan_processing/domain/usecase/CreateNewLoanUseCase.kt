package com.pogreb.loan_processing.domain.usecase

import com.pogreb.loan_processing.domain.entity.LoanData
import com.pogreb.loan_processing.domain.entity.LoanResult
import com.pogreb.loan_processing.domain.entity.UserData
import com.pogreb.loan_processing.domain.repository.LoanProcessingRepository
import javax.inject.Inject

class CreateNewLoanUseCase @Inject constructor(
    private val repository: LoanProcessingRepository
) : suspend (LoanData, UserData) -> LoanResult by repository::createNewLoan