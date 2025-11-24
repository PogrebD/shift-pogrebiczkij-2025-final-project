package com.pogreb.authorization.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pogreb.authorization.domain.entity.AuthorizationData
import com.pogreb.authorization.domain.entity.RegistrationData
import com.pogreb.authorization.domain.usecase.CheckAlreadyLoggedUseCase
import com.pogreb.authorization.domain.usecase.LoginUseCase
import com.pogreb.authorization.domain.usecase.RegistrationUseCase
import com.pogreb.authorization.presentation.state.AuthorizationState
import com.pogreb.design.component.InputErrorType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthorizationViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registrationUseCase: RegistrationUseCase,
    private val checkAlreadyLoggedUseCase: CheckAlreadyLoggedUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<AuthorizationState>(AuthorizationState.Initialize)
    val state: StateFlow<AuthorizationState> = _state.asStateFlow()

    suspend fun initialize() {
        if (_state.value is AuthorizationState.LoginContent
            || _state.value is AuthorizationState.RegistrationContent
        ) return

        _state.update { AuthorizationState.Loading }

        delay(2000)

        val alreadyLogged = checkAlreadyLoggedUseCase()
        if (alreadyLogged) {
            _state.update {
                AuthorizationState.AlreadyLogged
            }
        } else {
            setLoginState()
        }
    }

    fun login(authorizationData: AuthorizationData, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val logged = loginUseCase(authorizationData)
                onResult(logged)
            } catch (e: Exception) {
                _state.update {
                    when (val currentState = _state.value) {
                        is AuthorizationState.LoginContent -> currentState.copy(
                            errorMessage = e.message ?: ""
                        )

                        is AuthorizationState.RegistrationContent -> currentState.copy(
                            errorMessage = e.message ?: ""
                        )

                        else -> currentState
                    }
                }
                onResult(false)
            }
        }
    }

    fun registration(authorizationData: AuthorizationData, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val user = registrationUseCase(authorizationData)
                _state.update {
                    AuthorizationState.LoginContent(
                        authorizationData = AuthorizationData(
                            name = user.name,
                            password = "",
                        ),
                        loginErrorType = InputErrorType.NONE,
                        passwordErrorType = InputErrorType.NONE,
                        errorMessage = "",
                    )
                }
                val logged = loginUseCase(authorizationData)
                onResult(logged)
            } catch (e: Exception) {
                _state.update {
                    val currentState = _state.value as AuthorizationState.RegistrationContent
                    currentState.copy(errorMessage = e.message ?: "")
                }
                onResult(false)
            }
        }
    }

    fun setLoginState() {
        if (_state.value is AuthorizationState.LoginContent) return

        _state.update {
            AuthorizationState.LoginContent(
                authorizationData = AuthorizationData(
                    name = "",
                    password = "",
                ),
                loginErrorType = InputErrorType.NONE,
                passwordErrorType = InputErrorType.NONE,
                errorMessage = "",
            )
        }
    }

    fun setRegistrationState() {
        if (_state.value is AuthorizationState.RegistrationContent) return

        _state.update {
            AuthorizationState.RegistrationContent(
                registrationData = RegistrationData(
                    authorizationData = AuthorizationData(
                        name = "",
                        password = "",
                    ),
                    repeatPassword = "",
                ),
                loginErrorType = InputErrorType.NONE,
                passwordErrorType = InputErrorType.NONE,
                repeatPasswordErrorType = InputErrorType.NONE,
                errorMessage = ""
            )
        }
    }

    fun clearDialog() {
        _state.update {
            when (val currentState = _state.value) {
                is AuthorizationState.LoginContent -> currentState.copy(errorMessage = "")
                is AuthorizationState.RegistrationContent -> currentState.copy(errorMessage = "")
                else -> currentState
            }
        }
    }

    fun getAvailabilityApplyButton(): Boolean = // выглядит страшно
        when (val currentState = _state.value) {
            is AuthorizationState.LoginContent ->
                currentState.loginErrorType == InputErrorType.NONE
                        && currentState.passwordErrorType == InputErrorType.NONE
                        && currentState.authorizationData.password.isNotEmpty()
                        && currentState.authorizationData.name.isNotEmpty()

            is AuthorizationState.RegistrationContent ->
                currentState.loginErrorType == InputErrorType.NONE
                        && currentState.passwordErrorType == InputErrorType.NONE
                        && currentState.repeatPasswordErrorType == InputErrorType.NONE
                        && currentState.registrationData.authorizationData.password.isNotEmpty()
                        && currentState.registrationData.authorizationData.name.isNotEmpty()
                        && currentState.registrationData.repeatPassword.isNotEmpty()

            else -> false
        }

    fun updateLogin(login: String) {
        _state.update { currentState ->
            when (currentState) {
                is AuthorizationState.LoginContent -> {
                    var errorType = InputErrorType.NONE
                    if (!validateLogin(login)) {
                        errorType = InputErrorType.ONLY_LATIN_LETTERS_AND_NUMBERS
                    }
                    currentState.copy(
                        authorizationData = currentState.authorizationData.copy(name = login),
                        loginErrorType = errorType,
                    )
                }

                is AuthorizationState.RegistrationContent -> {
                    var errorType = InputErrorType.NONE
                    if (!validateLogin(login)) {
                        errorType = InputErrorType.ONLY_LATIN_LETTERS_AND_NUMBERS
                    }
                    currentState.copy(
                        registrationData = currentState.registrationData.copy(
                            authorizationData = currentState.registrationData.authorizationData.copy(
                                name = login
                            )
                        ),
                        loginErrorType = errorType,
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
                    var errorType = InputErrorType.NONE
                    if (!validatePassword(password)) {
                        errorType = InputErrorType.ONLY_LATIN_LETTERS_AND_NUMBERS
                    }
                    currentState.copy(
                        authorizationData = currentState.authorizationData.copy(password = password),
                        passwordErrorType = errorType,
                    )
                }

                is AuthorizationState.RegistrationContent -> {
                    var errorType = InputErrorType.NONE
                    if (!validatePassword(password)) {
                        errorType = InputErrorType.ONLY_LATIN_LETTERS_AND_NUMBERS
                    }
                    currentState.copy(
                        registrationData = currentState.registrationData.copy(
                            authorizationData = currentState.registrationData.authorizationData.copy(
                                password = password
                            )
                        ),
                        passwordErrorType = errorType,
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
                if (!validateRepeatPassword(currentState, repeatPassword)) {
                    errorType = InputErrorType.PASSWORDS_MISMATCH
                }
                currentState.copy(
                    registrationData = currentState.registrationData.copy(repeatPassword = repeatPassword),
                    repeatPasswordErrorType = errorType
                )
            } else currentState
        }
    }

    private fun validateLogin(login: String): Boolean {
        val regex = Regex("^[a-zA-Z0-9]+$")
        return regex.matches(login)
    }

    private fun validatePassword(login: String): Boolean {
        val regex = Regex("^[a-zA-Z0-9]+$")
        return regex.matches(login)
    }

    private fun validateRepeatPassword(
        currentState: AuthorizationState.RegistrationContent,
        repeatPassword: String
    ): Boolean {
        return repeatPassword ==
                currentState.registrationData.authorizationData.password
    }
}