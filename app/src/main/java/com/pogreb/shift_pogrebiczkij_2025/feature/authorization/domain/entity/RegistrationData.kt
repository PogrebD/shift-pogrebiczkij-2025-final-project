package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity

data class RegistrationData(
    val authorizationData: AuthorizationData,
    val repeatPassword: String,
)
