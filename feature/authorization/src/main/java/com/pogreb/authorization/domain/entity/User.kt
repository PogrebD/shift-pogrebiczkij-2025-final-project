package com.pogreb.authorization.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val role: Role,
)
