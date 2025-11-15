package com.pogreb.shift_pogrebiczkij_2025.feature.authorization.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
internal fun AuthorizationScreen() {
    AuthorizationLogoWithLoading()
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
        contentDescription = stringResource(R.string.app_logo_content_description),
    )
}

@Composable
private fun getLogoPainter(darkTheme: Boolean = isSystemInDarkTheme()) = when {
    darkTheme -> painterResource(R.drawable.logo_night)
    else -> painterResource(R.drawable.logo_day)
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewAuthorizationScreen() {
    AppTheme {
        AuthorizationScreen(
        )
    }
}