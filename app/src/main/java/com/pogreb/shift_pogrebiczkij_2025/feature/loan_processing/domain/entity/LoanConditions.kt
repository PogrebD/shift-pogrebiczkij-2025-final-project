package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity

data class LoanConditions(
    val percent: Double,
    val period: Int,
    val maxAmount: Int,
)
