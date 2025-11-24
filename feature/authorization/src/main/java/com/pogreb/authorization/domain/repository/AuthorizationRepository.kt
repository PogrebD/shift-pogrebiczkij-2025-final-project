package com.pogreb.authorization.domain.repository

import com.pogreb.authorization.domain.entity.AuthorizationData

interface AuthorizationRepository {
    suspend fun login(authorizationData: AuthorizationData): Boolean
    suspend fun register(authorizationData: AuthorizationData)
    suspend fun alreadyLogged(): Boolean
}