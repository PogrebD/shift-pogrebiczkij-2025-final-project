package com.pogreb.shift_pogrebiczkij_2025.core.network

import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException
import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR
import java.net.HttpURLConnection.HTTP_NOT_FOUND
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
                    is IOException -> NetworkException("Network error occurred")
                    else -> UnknownException("Unknown error: ${throwable.message}")
                }
            }

    private fun createException(response: Response): IOException =
        when (response.code) {
            HTTP_NOT_FOUND -> NotFoundException(response.message)
            HTTP_INTERNAL_ERROR -> InternalServerException(response.message)
            else -> InnerException(response.message)
        }
}

data class NotFoundException(override val message: String) :
    IOException(message) // вынести в отдельный класс

data class InternalServerException(override val message: String) : IOException(message)

data class InnerException(override val message: String) : IOException(message)

data class NetworkException(override val message: String) : IOException(message)

data class UnknownException(override val message: String) : IOException(message)