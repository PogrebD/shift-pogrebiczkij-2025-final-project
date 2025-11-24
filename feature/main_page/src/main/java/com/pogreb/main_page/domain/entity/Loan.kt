package com.pogreb.main_page.domain.entity

import com.pogreb.design.component.LoanStatus
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
