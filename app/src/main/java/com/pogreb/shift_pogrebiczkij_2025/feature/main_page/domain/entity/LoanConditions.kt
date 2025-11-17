package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity

data class LoanConditions(
    val maxAmount: Int,
    val percent: Double,
    val period: Int,
)