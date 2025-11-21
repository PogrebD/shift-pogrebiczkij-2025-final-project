package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.usecase

import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.entity.Loan
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.repository.LoanHistoryRepository
import javax.inject.Inject

class GetLoansUseCase @Inject constructor(
    private val repository: LoanHistoryRepository
) {
    suspend operator fun invoke(): List<Loan> =
        repository.getAllLoans()
            .reversed()
}