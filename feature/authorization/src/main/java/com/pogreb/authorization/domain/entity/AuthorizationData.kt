package com.pogreb.authorization.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class AuthorizationData(
    val name: String,
    val password: String
)
