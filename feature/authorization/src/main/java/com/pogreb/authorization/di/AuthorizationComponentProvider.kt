package com.pogreb.authorization.di

interface AuthorizationComponentProvider {
    fun provideAuthorizationComponent(): AuthorizationComponent
}