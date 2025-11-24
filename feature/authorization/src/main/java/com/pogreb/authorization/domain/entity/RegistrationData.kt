package com.pogreb.authorization.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationData(
    val authorizationData: AuthorizationData,
    val repeatPassword: String,
)
