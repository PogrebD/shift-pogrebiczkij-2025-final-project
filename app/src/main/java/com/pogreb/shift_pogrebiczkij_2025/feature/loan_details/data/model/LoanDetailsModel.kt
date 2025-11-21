package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.data.model

import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoanDetailsModel(
    val amount: Double,
    val date: String,
    @SerialName("firstName")
    val name: String,
    val id: Long,
    val lastName: String,
    val percent: Double,
    val period: Int,
    @SerialName("phoneNumber")
    val phone: String,
    @SerialName("state")
    val status: LoanStatus,
)