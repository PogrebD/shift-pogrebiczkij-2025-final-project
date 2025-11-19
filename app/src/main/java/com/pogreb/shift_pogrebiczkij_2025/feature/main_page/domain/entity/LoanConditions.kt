package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class LoanConditions(
    val percent: Double,
    val period: Int,
    val maxAmount: Int,
)