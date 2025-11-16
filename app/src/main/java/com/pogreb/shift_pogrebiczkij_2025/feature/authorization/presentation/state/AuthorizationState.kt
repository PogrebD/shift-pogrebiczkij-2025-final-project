package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.state

import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.RegistrationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.entity.InputErrorType

interface AuthorizationState {
    data object Initialize : AuthorizationState

    data object Loading : AuthorizationState

    data class LoginContent(
        val authorizationData: AuthorizationData,
        val errorType: InputErrorType,
    ) : AuthorizationState

    data class RegistrationContent(
        val registrationData: RegistrationData,
        val errorType: InputErrorType,
    ) : AuthorizationState
}