package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.AuthorizationTab
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.OutlinedInput
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.PasswordInput
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.PrimaryButton
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme


@Composable
internal fun AuthorizationContent(
    signUpMode: Boolean,
    loginText: String,
    passwordText: String,
    repeatPasswordText: String,
    loginErrorType: InputErrorType,
    passwordErrorType: InputErrorType,
    repeatPasswordErrorType: InputErrorType,
    onLoginTabClick: () -> Unit = {},
    onRegistrationTabClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onRegistrationClick: () -> Unit = {},
    onLoginValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit,
    onRepeatPasswordValueCChange: (String) -> Unit = {},
) {
    var passwordHidden by remember { mutableStateOf(true) }
    var repeatPasswordHidden by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseSurface)
            .clip(
                RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp
                )
            )
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp)
    ) {
        AuthorizationTab(
            onLoginClick = onLoginTabClick,
            onRegistrationClick = onRegistrationTabClick,
            signUpMode = signUpMode
        )

        OutlinedInput(
            label = "Логин",
            text = loginText,
            onValueChange = onLoginValueChange,
            errorType = loginErrorType,
        )

        PasswordInput(
            label = "Пароль",
            text = passwordText,
            onValueChange = onPasswordValueChange,
            passwordErrorType = passwordErrorType,
            passwordHidden = passwordHidden,
            onVisibilityClick = { passwordHidden = !passwordHidden },
        )

        if (signUpMode) {
            PasswordInput(
                label = "Повторите пароль",
                text = repeatPasswordText,
                onValueChange = onRepeatPasswordValueCChange,
                passwordErrorType = repeatPasswordErrorType,
                passwordHidden = repeatPasswordHidden,
                onVisibilityClick = { repeatPasswordHidden = !repeatPasswordHidden },
            )
        }

        ApplyButton(
            signUpMode,
            onLoginClick = onLoginClick,
            onRegistrationClick = onRegistrationClick,
        )
    }
}


@Composable
fun ApplyButton(
    signUpMode: Boolean,
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
) {
    if (signUpMode) {
        PrimaryButton(
            onClick = { onRegistrationClick() },
            text = stringResource(R.string.label_registration),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    } else {
        PrimaryButton(
            onClick = { onLoginClick() },
            text = stringResource(R.string.label_login),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    }
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0x88998899
)
@Composable
private fun PreviewAuthorizationContent() {
    AppTheme {
        AuthorizationContent(
            signUpMode = true,
            loginText = "sdfsd",
            passwordText = "sdfsd",
            repeatPasswordText = "sdfsd",
            onLoginClick = { },
            onRegistrationClick = { },
            onLoginValueChange = { },
            onPasswordValueChange = { },
            onRepeatPasswordValueCChange = { },
            loginErrorType = InputErrorType.NONE,
            passwordErrorType = InputErrorType.NONE,
            repeatPasswordErrorType = InputErrorType.NONE,
            onLoginTabClick = {},
            onRegistrationTabClick = {},
        )
    }
}