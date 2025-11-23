package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.state

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.RegistrationData
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType

interface AuthorizationState {
    data object Initialize : AuthorizationState

    data object Loading : AuthorizationState

    data class LoginContent(
        val authorizationData: AuthorizationData,
        val loginErrorType: InputErrorType,
        val passwordErrorType: InputErrorType,
        val errorMessage: String,
    ) : AuthorizationState

    data class RegistrationContent(
        val registrationData: RegistrationData,
        val loginErrorType: InputErrorType,
        val passwordErrorType: InputErrorType,
        val repeatPasswordErrorType: InputErrorType,
        val errorMessage: String,
    ) : AuthorizationState

    data object AlreadyLogged : AuthorizationState
}