package com.pogreb.shift_pogrebiczkij_2025.core.network

import okio.IOException

data class DomainException(override val message: String?) :
    IOException(message)

data class InternalServerException(override val message: String) : IOException(message)

data class InnerException(override val message: String) : IOException(message)

data class NetworkException(override val message: String) : IOException(message)

data class UnknownException(override val message: String) : IOException(message)