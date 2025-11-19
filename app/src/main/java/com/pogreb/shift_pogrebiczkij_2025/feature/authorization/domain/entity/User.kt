package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val role: Role,
)
