package com.pogreb.main_page.domain.usecase

import com.pogreb.main_page.domain.entity.Loan
import com.pogreb.main_page.domain.repository.MainPageRepository
import javax.inject.Inject

class GetRecentLoansUseCase @Inject constructor(
    private val repository: MainPageRepository
) {
    suspend operator fun invoke(): List<Loan> =
        repository.getAllLoans()
            .take(3)
}