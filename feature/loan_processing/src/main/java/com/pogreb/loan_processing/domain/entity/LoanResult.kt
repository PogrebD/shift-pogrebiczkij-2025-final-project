package com.pogreb.loan_processing.domain.entity

import com.pogreb.design.component.LoanStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoanResult(
    val date: String,
    @SerialName("state")
    val status: LoanStatus,
)