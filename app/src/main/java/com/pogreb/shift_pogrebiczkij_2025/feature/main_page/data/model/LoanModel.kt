package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.data.model

import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus
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