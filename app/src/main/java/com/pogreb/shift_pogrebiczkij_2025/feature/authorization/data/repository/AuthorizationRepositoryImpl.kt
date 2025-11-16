package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.data.repository

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.data.datasource.remote.RemoteAuthorizationDataSource
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.User
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.repository.AuthorizationRepository

class AuthorizationRepositoryImpl(
    private val remoteDataSource: RemoteAuthorizationDataSource
) : AuthorizationRepository {
    override suspend fun login(authorizationData: AuthorizationData): String =
        remoteDataSource.login(authorizationData)

    override suspend fun register(authorizationData: AuthorizationData): User =
        remoteDataSource.registration(authorizationData)
}