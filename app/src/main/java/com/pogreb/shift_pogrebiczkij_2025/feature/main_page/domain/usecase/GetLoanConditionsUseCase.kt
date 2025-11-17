package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.usecase

import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.LoanConditions
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.repository.MainPageRepository
import javax.inject.Inject

class GetLoanConditionsUseCase @Inject constructor(
    private val repository: MainPageRepository
) : suspend () -> LoanConditions by repository::getLoanConditions