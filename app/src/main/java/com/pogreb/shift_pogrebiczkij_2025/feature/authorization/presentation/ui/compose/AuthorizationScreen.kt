package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.state.AuthorizationState
import com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.viewmodel.AuthorizationViewModel
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType

@Composable
internal fun AuthorizationScreen(
    viewModel: AuthorizationViewModel,
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }

    Scaffold { paddingValues ->
        when (val currentState = state) {
            is AuthorizationState.Loading -> AuthorizationLogoWithLoading()

            is AuthorizationState.LoginContent -> {
                Column(
                    modifier = Modifier
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    AuthorizationLogo(
                        modifier = Modifier
                            .weight(1f),
                    )

                    AuthorizationContent(
                        signUpMode = false,
                        loginText = currentState.authorizationData.name,
                        passwordText = currentState.authorizationData.password,
                        repeatPasswordText = "",
                        loginErrorType = currentState.loginErrorType,
                        passwordErrorType = currentState.passwordErrorType,
                        repeatPasswordErrorType = InputErrorType.NONE,
                        onLoginClick = {
                            val logged: Boolean =
                                viewModel.login(currentState.authorizationData)

                            if (logged) {
                                onLoginClick
                            }
                        },
                        onRegistrationTabClick = { viewModel.setRegistrationState() },
                        onLoginValueChange = { viewModel.updateLogin(it) },
                        onPasswordValueChange = { viewModel.updatePassword(it) },
                    )

                    //test button
                    Button(
                        onClick = onLoginClick,
                        content = { Text("go to onboarding") }
                    )
                }
            }

            is AuthorizationState.RegistrationContent -> {
                Column(
                    modifier = Modifier
                        .padding(paddingValues),
                ) {
                    AuthorizationLogo(
                        modifier = Modifier
                            .weight(1f),
                    )

                    AuthorizationContent(
                        signUpMode = true,
                        loginText = currentState.registrationData.authorizationData.name,
                        passwordText = currentState.registrationData.authorizationData.password,
                        repeatPasswordText = currentState.registrationData.repeatPassword,
                        loginErrorType = currentState.loginErrorType,
                        passwordErrorType = currentState.passwordErrorType,
                        repeatPasswordErrorType = currentState.repeatPasswordErrorType,
                        onRegistrationClick = { viewModel.registration(currentState.registrationData.authorizationData) },
                        onLoginTabClick = { viewModel.setLoginState() },
                        onLoginValueChange = { viewModel.updateLogin(it) },
                        onPasswordValueChange = { viewModel.updatePassword(it) },
                        onRepeatPasswordValueCChange = { viewModel.updateRepeatPassword(it) },
                    )
                }
            }

            is AuthorizationState.AlreadyLogged -> {
                onLoginClick()
            }
        }
    }
}

@Composable
private fun AuthorizationLogo(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.inverseSurface)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Logo()
        }
    }
}

@Composable
private fun AuthorizationLogoWithLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Logo()

            CircularProgressIndicator(
                modifier = Modifier,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Composable
private fun Logo() {
    Image(
        painter = getLogoPainter(),
        contentDescription = stringResource(R.string.content_description_app_logo),
    )
}

@Composable
private fun getLogoPainter(darkTheme: Boolean = isSystemInDarkTheme()) = when {
    darkTheme -> painterResource(R.drawable.logo_day)
    else -> painterResource(R.drawable.logo_night)
}