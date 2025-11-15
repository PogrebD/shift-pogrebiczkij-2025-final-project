package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.User

interface AuthorizationRepository {
    suspend fun login(authorizationData: AuthorizationData): String
    suspend fun register(authorizationData: AuthorizationData): User
}