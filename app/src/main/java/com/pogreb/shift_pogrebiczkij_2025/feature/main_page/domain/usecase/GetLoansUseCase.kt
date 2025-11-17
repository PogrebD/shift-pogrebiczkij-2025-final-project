package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.usecase

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.Loan
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.repository.MainPageRepository
import javax.inject.Inject

class GetLoansUseCase @Inject constructor(
    private val repository: MainPageRepository
) : suspend () -> List<Loan> by repository::getLoans