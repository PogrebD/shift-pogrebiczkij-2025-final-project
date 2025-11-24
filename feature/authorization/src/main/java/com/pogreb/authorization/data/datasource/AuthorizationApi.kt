package com.pogreb.authorization.data.datasource

import com.pogreb.authorization.domain.entity.AuthorizationData
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationApi {
    @POST("login")
    suspend fun login(@Body authorizationData: AuthorizationData): String

    @POST("registration")
    suspend fun registration(@Body authorizationData: AuthorizationData)
}