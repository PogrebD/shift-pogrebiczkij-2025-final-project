package com.pogreb.loan_processing.domain.entity

data class LoanData(
    val percent: Double,
    val period: Int,
    val amount: Long,
)
