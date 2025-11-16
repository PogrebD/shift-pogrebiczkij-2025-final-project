package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.data.datasource.remote

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import javax.inject.Inject

class RemoteAuthorizationDataSource @Inject constructor(
    private val api: AuthorizationApi,
) {
    suspend fun login(authorizationData: AuthorizationData) =
        api.login(authorizationData)

    suspend fun registration(authorizationData: AuthorizationData) =
        api.registration(authorizationData)
}