package com.pogreb.loan_details.domain.entity

import com.pogreb.design.component.LoanStatus

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
