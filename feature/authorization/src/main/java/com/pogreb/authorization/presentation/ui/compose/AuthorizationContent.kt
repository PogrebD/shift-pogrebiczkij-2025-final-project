package com.pogreb.authorization.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.pogreb.design.R
import com.pogreb.design.component.AuthorizationTab
import com.pogreb.design.component.ErrorDialogWithoutDismiss
import com.pogreb.design.component.InputErrorType
import com.pogreb.design.component.OutlinedInput
import com.pogreb.design.component.PasswordInput
import com.pogreb.design.component.PrimaryButton
import com.pogreb.design.theme.AppTheme

@Composable
internal fun AuthorizationContent(
    signUpMode: Boolean,
    loginText: String,
    passwordText: String,
    repeatPasswordText: String,
    loginErrorType: InputErrorType,
    passwordErrorType: InputErrorType,
    repeatPasswordErrorType: InputErrorType,
    errorMessage: String,
    buttonEnabled: Boolean,
    onLoginTabClick: () -> Unit = {},
    onRegistrationTabClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onRegistrationClick: () -> Unit = {},
    onLoginValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit,
    onRepeatPasswordValueCChange: (String) -> Unit = {},
    onRetryClick: () -> Unit,
) {
    var passwordHidden by remember { mutableStateOf(true) }
    var repeatPasswordHidden by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp
                )
            )
            .padding(top = 2.dp)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp
                )
            )
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
            label = stringResource(R.string.label_login),
            text = loginText,
            onValueChange = onLoginValueChange,
            errorType = loginErrorType,
        )

        PasswordInput(
            label = stringResource(R.string.label_password),
            text = passwordText,
            onValueChange = onPasswordValueChange,
            passwordErrorType = passwordErrorType,
            passwordHidden = passwordHidden,
            onVisibilityClick = { passwordHidden = !passwordHidden },
        )

        if (signUpMode) {
            PasswordInput(
                label = stringResource(R.string.label_repeat_password),
                text = repeatPasswordText,
                onValueChange = onRepeatPasswordValueCChange,
                passwordErrorType = repeatPasswordErrorType,
                passwordHidden = repeatPasswordHidden,
                onVisibilityClick = { repeatPasswordHidden = !repeatPasswordHidden },
            )
        }

        ApplyButton(
            signUpMode = signUpMode,
            onLoginClick = onLoginClick,
            onRegistrationClick = onRegistrationClick,
            buttonEnabled = buttonEnabled,
        )

        ErrorDialogWithoutDismiss(
            message = errorMessage,
            onRetry = onRetryClick,
        )
    }
}

@Composable
private fun ApplyButton(
    buttonEnabled: Boolean,
    signUpMode: Boolean,
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
) {
    if (signUpMode) {
        PrimaryButton(
            onClick = { onRegistrationClick() },
            text = stringResource(R.string.label_registration),
            modifier = Modifier
                .padding(vertical = 16.dp),
            enabled = buttonEnabled
        )
    } else {
        PrimaryButton(
            onClick = { onLoginClick() },
            text = stringResource(R.string.label_enter),
            modifier = Modifier
                .padding(vertical = 16.dp),
            enabled = buttonEnabled
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
            errorMessage = "",
            onRetryClick = {},
            buttonEnabled = true,
        )
    }
}