package com.pogreb.shift_pogrebiczkij_2025.shared.design.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType.INVALID_FORMAT
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType.NONE
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType.PASSWORDS_MISMATCH
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType.USER_NOT_FOUND
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
fun LoginInput(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    loginErrorType: InputErrorType,
) {
    val isError = loginErrorType != InputErrorType.NONE

    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        label = { Text(text = label) },
        supportingText = {
            if (isError) {
                ErrorText(loginErrorType)
            }
        },
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedBorderColor = MaterialTheme.colorScheme.outline,
            errorLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.onPrimary,
                backgroundColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f),
            )
        )
    )
}

@Composable
fun PasswordInput(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    passwordErrorType: InputErrorType,
    passwordHidden: Boolean,
    onVisibilityClick: () -> Unit,
) {
    val isError = passwordErrorType != InputErrorType.NONE

    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        label = { Text(text = label) },
        trailingIcon = { PasswordModeIcon(passwordHidden, onVisibilityClick) },
        supportingText = {
            if (isError) {
                ErrorText(passwordErrorType)
            }
        },
        isError = isError,
        visualTransformation = getVisualTransformation(passwordHidden),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedBorderColor = MaterialTheme.colorScheme.outline,
            errorLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.onPrimary,
                backgroundColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f),
            )
        )
    )
}

@Composable
private fun PasswordModeIcon(passwordHidden: Boolean, onVisibilityClick: () -> Unit) {
    IconButton(
        onClick = onVisibilityClick,
        content = {
            Icon(
                painter = getPasswordPainter(passwordHidden),
                contentDescription = stringResource(R.string.hidden_content_description),
            )
        }
    )
}

@Composable
private fun getPasswordPainter(passwordHidden: Boolean) = when {
    passwordHidden -> painterResource(R.drawable.hidden)
    else -> painterResource(R.drawable.visible)
}

@Composable
private fun getVisualTransformation(passwordHidden: Boolean) = when {
    passwordHidden -> PasswordVisualTransformation(
        mask = '*'
    )

    else -> VisualTransformation.None
}


@Composable
private fun ErrorText(errorType: InputErrorType) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        content = {
            Text(text = getErrorText(errorType))
        }
    )
}

enum class InputErrorType {
    PASSWORDS_MISMATCH,
    INVALID_FORMAT,
    USER_NOT_FOUND,
    NONE;
}

@Composable
fun getErrorText(type: InputErrorType): String = when (type) {
    PASSWORDS_MISMATCH -> stringResource(R.string.error_passwords_missmatch)
    INVALID_FORMAT -> stringResource(R.string.error_invalid_format)
    USER_NOT_FOUND -> stringResource(R.string.error_user_not_found)
    NONE -> ""
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewInput() {
    AppTheme {
        Column {
            PasswordInput(
                label = "Текст",
                text = "Текст",
                onValueChange = { },
                passwordHidden = false,
                onVisibilityClick = {},
                passwordErrorType = InputErrorType.NONE,
            )

            LoginInput(
                label = "Текст",
                text = "Текст",
                onValueChange = { },
                loginErrorType = InputErrorType.INVALID_FORMAT,
            )
        }
    }
}