package com.pogreb.loan_history.data.model

import com.pogreb.design.component.LoanStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoanModel(
    val id: Long,
    val amount: Double,
    @SerialName("state")
    val status: LoanStatus,
    val date: String,
)