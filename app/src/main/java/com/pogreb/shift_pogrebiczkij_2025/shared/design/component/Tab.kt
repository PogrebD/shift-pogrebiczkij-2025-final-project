package com.pogreb.shift_pogrebiczkij_2025.shared.design.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.bgDisable

@Composable
fun AuthorizationTab(
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
    signUpMode: Boolean = false,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 17.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LoginTextButton(
            modifier = Modifier
                .weight(1f),
            onLoginClick = onLoginClick,
            signUpMode = signUpMode,
        )

        VerticalDivider(
            modifier = Modifier
                .height(32.dp),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.bgDisable
        )

        RegistrationTextButton(
            modifier = Modifier
                .weight(1f),
            onRegistrationClick = onRegistrationClick,
            signUpMode = signUpMode,
        )
    }
}

@Composable
fun LoginTextButton(modifier: Modifier, onLoginClick: () -> Unit, signUpMode: Boolean) {
    Text(
        text = stringResource(R.string.login_title),
        modifier = modifier
            .clickable(enabled = true, onClick = onLoginClick),
        color = getLoginTextColor(signUpMode),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium,
    )
}


@Composable
fun RegistrationTextButton(
    modifier: Modifier,
    onRegistrationClick: () -> Unit,
    signUpMode: Boolean
) {
    Text(
        text = stringResource(R.string.registration_title),
        modifier = modifier
            .clickable(enabled = true, onClick = onRegistrationClick),
        color = getRegistrationTextColor(signUpMode),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
fun getLoginTextColor(
    signUpMode: Boolean,
) = when {
    signUpMode ->
        MaterialTheme.colorScheme.onSurfaceVariant

    else ->
        MaterialTheme.colorScheme.secondary
}

@Composable
fun getRegistrationTextColor(
    signUpMode: Boolean,
) = when {
    signUpMode ->
        MaterialTheme.colorScheme.secondary

    else ->
        MaterialTheme.colorScheme.onSurfaceVariant
}


@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun PreviewAuthorizationTab() {
    AppTheme {
        AuthorizationTab(
            onLoginClick = {},
            onRegistrationClick = {},
        )
    }
}