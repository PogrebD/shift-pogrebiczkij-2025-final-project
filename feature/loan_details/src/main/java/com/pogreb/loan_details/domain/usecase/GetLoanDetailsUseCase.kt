package com.pogreb.loan_details.domain.usecase

import com.pogreb.loan_details.domain.entity.LoanDetails
import com.pogreb.loan_details.domain.repository.LoanDetailsRepository
import javax.inject.Inject

class GetLoanDetailsUseCase @Inject constructor(
    private val repository: LoanDetailsRepository
) : suspend (Long) -> LoanDetails by repository::getLoanDetails