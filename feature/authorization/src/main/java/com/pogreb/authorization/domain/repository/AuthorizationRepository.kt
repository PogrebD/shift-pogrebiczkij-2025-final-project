package com.pogreb.authorization.domain.repository

import com.pogreb.authorization.domain.entity.AuthorizationData
import com.pogreb.authorization.domain.entity.User

interface AuthorizationRepository {
    suspend fun login(authorizationData: AuthorizationData): Boolean
    suspend fun register(authorizationData: AuthorizationData): User
    suspend fun alreadyLogged(): Boolean
}