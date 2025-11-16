package com.pogreb.shift_pogrebiczkij_2025.app.di

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponent
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.di.AuthorizationComponentProvider

interface ComponentProvider :
    AuthorizationComponentProvider {
    override fun provideAuthorizationComponent(): AuthorizationComponent
}