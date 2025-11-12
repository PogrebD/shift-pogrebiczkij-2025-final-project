package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.AuthorizationTab
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.DefaultInput
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.PasswordInput
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme


@Composable
fun AuthorizationContent(
    signUpMode: Boolean,
    loginText: String,
    passwordText: String,
    repeatPasswordText: String,
    loginInvalid: Boolean,
    loginErrorText: String,
    passwordInvalid: Boolean,
    passwordErrorText: String,
    repeatPasswordInvalid: Boolean,
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
    onLoginValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit,
    onRepeatPasswordValueCChange: (String) -> Unit,
) {
    var passwordHidden by remember { mutableStateOf(true) }
    var repeatPasswordHidden by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp
                )
            )
    ) {
        AuthorizationTab(
            onLoginClick = onLoginClick,
            onRegistrationClick = onRegistrationClick,
            signUpMode = signUpMode
        )

        DefaultInput(
            label = "Логин",
            text = loginText,
            onValueChange = onLoginValueChange,
            invalid = loginInvalid,
            errorText = loginErrorText,
        )

        PasswordInput(
            label = "Пароль",
            text = passwordText,
            onValueChange = onPasswordValueChange,
            invalid = passwordInvalid,
            errorText = passwordErrorText,
            passwordHidden = passwordHidden,
            onVisibilityClick = { passwordHidden = !passwordHidden },
        )

        if (signUpMode) {
            PasswordInput(
                label = "Повторите пароль",
                text = repeatPasswordText,
                onValueChange = onRepeatPasswordValueCChange,
                invalid = repeatPasswordInvalid,
                errorText = "Пароли не совпадают",
                passwordHidden = repeatPasswordHidden,
                onVisibilityClick = { repeatPasswordHidden = !repeatPasswordHidden },
            )
        }
    }
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun PreviewAuthorizationContent() {
    AppTheme {
        AuthorizationContent(
            signUpMode = true,
            loginText = "sdfsd",
            passwordText = "sdfsd",
            repeatPasswordText = "sdfsd",
            loginInvalid = false,
            loginErrorText = "sdfsd",
            passwordInvalid = false,
            passwordErrorText = "sdfsd",
            repeatPasswordInvalid = false,
            onLoginClick = { },
            onRegistrationClick = { },
            onLoginValueChange = { },
            onPasswordValueChange = { },
            onRepeatPasswordValueCChange = { },
        )
    }
}