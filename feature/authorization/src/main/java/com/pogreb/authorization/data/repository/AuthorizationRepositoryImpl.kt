package com.pogreb.authorization.data.repository

import com.pogreb.authorization.data.datasource.remote.RemoteAuthorizationDataSource
import com.pogreb.authorization.domain.entity.AuthorizationData
import com.pogreb.authorization.domain.entity.User
import com.pogreb.authorization.domain.repository.AuthorizationRepository
import com.pogreb.core.network.TokenManager
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteAuthorizationDataSource,
    private val tokenManager: TokenManager
) : AuthorizationRepository {
    override suspend fun login(authorizationData: AuthorizationData): Boolean {
        val token = remoteDataSource.login(authorizationData)
        if (token.isNotEmpty()) {
            tokenManager.saveToken(token)
            return true
        }
        return false
    }

    override suspend fun register(authorizationData: AuthorizationData): User =
        remoteDataSource.registration(authorizationData)

    override suspend fun alreadyLogged(): Boolean {
        return tokenManager.getToken() != null
    }
}