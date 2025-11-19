package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.usecase

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.LoanConditions
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity.UserData
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.repository.LoanProcessingRepository
import javax.inject.Inject

class CreateNewLoanUseCase @Inject constructor(
    private val repository: LoanProcessingRepository
) : suspend (LoanConditions, UserData) -> String by repository::createNewLoan