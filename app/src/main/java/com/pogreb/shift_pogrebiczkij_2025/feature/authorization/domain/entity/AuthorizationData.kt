package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class AuthorizationData(
    val name: String,
    val password: String
)
