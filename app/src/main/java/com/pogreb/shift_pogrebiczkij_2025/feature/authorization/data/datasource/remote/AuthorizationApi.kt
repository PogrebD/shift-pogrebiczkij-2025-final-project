package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.data.datasource.remote

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationApi {
    @POST("login")
    suspend fun login(@Body authorizationData: AuthorizationData): String

    @POST("registration")
    suspend fun registration(@Body authorizationData: AuthorizationData): User
}