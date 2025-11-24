package com.pogreb.authorization.data.datasource.remote

import com.pogreb.authorization.domain.entity.AuthorizationData
import com.pogreb.authorization.domain.entity.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationApi {
    @POST("login")
    suspend fun login(@Body authorizationData: AuthorizationData): String

    @POST("registration")
    suspend fun registration(@Body authorizationData: AuthorizationData): User
}