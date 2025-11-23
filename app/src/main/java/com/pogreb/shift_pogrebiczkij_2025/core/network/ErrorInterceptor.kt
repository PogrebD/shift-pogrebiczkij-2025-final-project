package com.pogreb.shift_pogrebiczkij_2025.core.network

import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.HttpURLConnection.HTTP_FORBIDDEN
import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR
import java.net.HttpURLConnection.HTTP_NOT_FOUND
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class ErrorInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        runCatching { chain.proceed(chain.request()) }
            .mapCatching { response ->
                response.takeIf { it.isSuccessful }
                    ?: throw createException(response)
            }
            .getOrElse { throwable ->
                throw when (throwable) {
                    is SocketTimeoutException -> NetworkException("Request timeout")
                    is UnknownHostException -> NetworkException("No internet connection")
                    is IOException -> NetworkException(
                        throwable.message ?: "Network error occurred"
                    )

                    else -> UnknownException("Unknown error")
                }
            }

    private fun createException(response: Response): IOException =
        when (response.code) {
            HTTP_BAD_REQUEST -> DomainException(parseErrorMessage(response.body.string()))
            HTTP_UNAUTHORIZED -> DomainException(parseErrorMessage(response.body.string()))
            HTTP_FORBIDDEN -> DomainException("Access denied")
            HTTP_NOT_FOUND -> DomainException(parseErrorMessage(response.body.string()))
            HTTP_INTERNAL_ERROR -> InternalServerException("Internal error")
            else -> InnerException("Inner error")
        }

    fun parseErrorMessage(input: String): String? {
        return input.substringAfter("\"")
            .takeIf { it != input }
            ?.substringBeforeLast("\"")
            ?.takeIf { it.isNotEmpty() }
    }
}

