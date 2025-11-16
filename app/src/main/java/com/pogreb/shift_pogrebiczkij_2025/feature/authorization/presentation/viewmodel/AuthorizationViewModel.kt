package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.AuthorizationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.entity.RegistrationData
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.usecase.LoginUseCase
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.domain.usecase.RegistrationUseCase
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.entity.InputErrorType
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.state.AuthorizationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthorizationViewModel(
    private val loginUseCase: LoginUseCase,
    private val registrationUseCase: RegistrationUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<AuthorizationState>(AuthorizationState.Initialize)
    val state: StateFlow<AuthorizationState> = _state.asStateFlow()

    fun loadLoin() {
        _state.update { AuthorizationState.Loading }
        _state.update {
            AuthorizationState.LoginContent(
                authorizationData = AuthorizationData(
                    name = "",
                    password = "",
                ),
                errorType = InputErrorType.NONE
            )
        }
    }

    fun login(authorizationData: AuthorizationData) {
        viewModelScope.launch {
            loginUseCase(authorizationData)
        }
    }

    fun registration(authorizationData: AuthorizationData) {
        viewModelScope.launch {
            registrationUseCase(authorizationData)
        }
    }

    fun setLoginState() {
        _state.update {
            AuthorizationState.LoginContent(
                authorizationData = AuthorizationData(
                    name = "",
                    password = "",
                ),
                errorType = InputErrorType.NONE
            )
        }
    }

    fun setRegistrationState() {
        _state.update {
            AuthorizationState.RegistrationContent(
                registrationData = RegistrationData(
                    authorizationData = AuthorizationData(
                        name = "",
                        password = "",
                    ),
                    repeatPassword = "",
                ),
                errorType = InputErrorType.NONE
            )
        }
    }

    fun updateLogin(login: String) {
        _state.update { currentState ->
            when (currentState) {
                is AuthorizationState.LoginContent -> {
                    var errorType = InputErrorType.NONE
                    if (!validateLogin(login)) {
                        errorType = InputErrorType.INVALID_LOGIN_FORMAT
                    }
                    currentState.copy(
                        authorizationData = currentState.authorizationData.copy(name = login),
                        errorType = errorType,
                    )
                }

                is AuthorizationState.RegistrationContent -> {
                    var errorType = InputErrorType.NONE
                    if (!validateLogin(login)) {
                        errorType = InputErrorType.INVALID_LOGIN_FORMAT
                    }
                    currentState.copy(
                        registrationData = currentState.registrationData.copy(
                            authorizationData = currentState.registrationData.authorizationData.copy(
                                name = login
                            )
                        ),
                        errorType = errorType,
                    )
                }

                else -> currentState
            }
        }
    }

    fun updatePassword(password: String) {
        _state.update { currentState ->
            when (currentState) {
                is AuthorizationState.LoginContent -> {
                    currentState.copy(
                        authorizationData = currentState.authorizationData.copy(password = password)
                    )
                }

                is AuthorizationState.RegistrationContent -> {
                    currentState.copy(
                        registrationData = currentState.registrationData.copy(
                            authorizationData = currentState.registrationData.authorizationData.copy(
                                password = password
                            )
                        )
                    )
                }

                else -> currentState
            }
        }
    }

    fun updateRepeatPassword(repeatPassword: String) {
        _state.update { currentState ->
            if (currentState is AuthorizationState.RegistrationContent) {
                var errorType = InputErrorType.NONE
                if (!validateRepeatPassword(currentState)) {
                    errorType = InputErrorType.PASSWORDS_MISMATCH
                }
                currentState.copy(
                    registrationData = currentState.registrationData.copy(repeatPassword = repeatPassword),
                    errorType = errorType
                )
            } else currentState
        }
    }

    fun validateLogin(login: String): Boolean {
        val regex = Regex("^[a-zA-Z0-9]+$")
        return regex.matches(login)
    }

    fun validateRepeatPassword(currentState: AuthorizationState.RegistrationContent): Boolean {
        return currentState.registrationData.repeatPassword ==
                currentState.registrationData.authorizationData.password
    }
}