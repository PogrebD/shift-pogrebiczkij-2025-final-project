package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity

import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus

data class Loan(
    val id: Long,
    val amount: Long,
    val status: LoanStatus,
    val date: String,
)
