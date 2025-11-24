package com.pogreb.design.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.pogreb.design.R
import com.pogreb.design.theme.AppTheme
import com.pogreb.design.theme.bgDisable

@Composable
fun AuthorizationTab(
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit,
    signUpMode: Boolean = false,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
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
private fun LoginTextButton(modifier: Modifier, onLoginClick: () -> Unit, signUpMode: Boolean) {
    Button(
        onClick = onLoginClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        content = {
            Text(
                text = stringResource(R.string.title_login),
                color = getLoginTextColor(signUpMode),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    )

}


@Composable
private fun RegistrationTextButton(
    modifier: Modifier,
    onRegistrationClick: () -> Unit,
    signUpMode: Boolean
) {
    Button(
        onClick = onRegistrationClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        content = {
            Text(
                text = stringResource(R.string.title_registration),
                color = getRegistrationTextColor(signUpMode),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    )
}

@Composable
private fun getLoginTextColor(
    signUpMode: Boolean,
) = when {
    signUpMode ->
        MaterialTheme.colorScheme.onSurfaceVariant

    else ->
        MaterialTheme.colorScheme.secondary
}

@Composable
private fun getRegistrationTextColor(
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
private fun PreviewAuthorizationTab() {
    AppTheme {
        AuthorizationTab(
            onLoginClick = {},
            onRegistrationClick = {},
        )
    }
}