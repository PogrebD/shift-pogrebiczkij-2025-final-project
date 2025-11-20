package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.domain.entity

import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Loan(
    val id: Long,
    val amount: Long,
    @SerialName("state")
    val status: LoanStatus,
    val date: String,
)