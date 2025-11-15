package com.pogreb.shift_pogrebiczkij_2025.shared.design.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
fun DefaultInput(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    invalid: Boolean,
    errorText: String,
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        label = { Text(text = label) },
        supportingText = { ErrorText(errorText, invalid) },
        isError = invalid,
    )
}

@Composable
fun PasswordInput(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    invalid: Boolean,
    errorText: String,
    passwordHidden: Boolean,
    onVisibilityClick: () -> Unit,
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        label = { Text(text = label) },
        trailingIcon = { PasswordModeIcon(passwordHidden, onVisibilityClick) },
        supportingText = { ErrorText(errorText, invalid) },
        isError = invalid,
        visualTransformation = getVisualTransformation(passwordHidden),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
private fun ErrorText(text: String, invalid: Boolean) = when {
    invalid -> Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        content = {
            Text(text = text)
        }
    )

    else -> null
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
                invalid = false,
                errorText = "Только русские буквы",
                passwordHidden = false,
                onVisibilityClick = {},
            )

            DefaultInput(
                label = "Текст",
                text = "Текст",
                onValueChange = { },
                invalid = false,
                errorText = "Только русские буквы",
            )
        }
    }
}