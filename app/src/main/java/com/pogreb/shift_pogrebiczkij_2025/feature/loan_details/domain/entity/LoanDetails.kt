package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.domain.entity

import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus

data class LoanDetails(
    val amount: Long,
    val date: String,
    val name: String,
    val id: Long,
    val lastName: String,
    val percent: Double,
    val period: Int,
    val phone: String,
    val status: LoanStatus,
)
