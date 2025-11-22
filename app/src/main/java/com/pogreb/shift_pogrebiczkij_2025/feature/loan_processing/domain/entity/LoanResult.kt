package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.domain.entity

import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoanResult(
    val date: String,
    @SerialName("state")
    val status: LoanStatus,
)