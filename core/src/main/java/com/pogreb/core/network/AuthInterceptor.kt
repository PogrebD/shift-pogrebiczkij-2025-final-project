package com.pogreb.core.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = tokenManager.getToken()

        val response = chain.proceed(
            originalRequest.withToken(token)
        )

        if (response.code == 401) {
            tokenManager.clearToken()
        }

        return response
    }

    private fun Request.withToken(token: String?): Request {
        return if (token != null) {
            this.newBuilder()
                .header("Authorization", token)
                .build()
        } else {
            this
        }
    }
}