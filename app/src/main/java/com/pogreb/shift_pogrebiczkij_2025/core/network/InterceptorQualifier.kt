package com.pogreb.shift_pogrebiczkij_2025.core.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ErrorInterceptorQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthInterceptorQualifier
