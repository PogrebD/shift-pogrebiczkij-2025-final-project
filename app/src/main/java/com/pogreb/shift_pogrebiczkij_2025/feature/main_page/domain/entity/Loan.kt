package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity

data class Loan(
    val id: Long,
    val amount: Double,
    val state: LoanState,
    val date: String,
)
