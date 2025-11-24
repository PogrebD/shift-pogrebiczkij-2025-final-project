package com.pogreb.design.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.design.R

@Composable
fun ErrorDialog(
    message: String,
    onRetry: () -> Unit,
    onCancel: () -> Unit,
) {
    if (message.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = onCancel,
            title = { Title() },
            text = { Text(text = message) },
            confirmButton = { ConfirmButton(onRetry = onRetry) },
            dismissButton = { DismissButton(onRetry = onRetry) },
            containerColor = MaterialTheme.colorScheme.background
        )
    }
}

@Composable
fun ErrorDialogWithoutDismiss(
    message: String,
    onRetry: () -> Unit,
) {
    if (message.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = onRetry,
            title = { Title() },
            text = { Text(text = message) },
            confirmButton = { ConfirmButton(onRetry = onRetry) },
            containerColor = MaterialTheme.colorScheme.background
        )
    }
}

@Composable
private fun DismissButton(onRetry: () -> Unit) {
    TertiaryButton(
        onClick = onRetry,
        text = stringResource(R.string.label_cancel),
        modifier = Modifier,
        enabled = true,
    )
}

@Composable
private fun ConfirmButton(onRetry: () -> Unit) {
    TertiaryButton(
        onClick = onRetry,
        text = stringResource(R.string.label_try_again),
        modifier = Modifier,
        enabled = true,
    )
}

@Composable
private fun Title() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.title_error)
        )

        Icon(
            painter = painterResource(R.drawable.outline_sentiment_dissatisfied_24),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = stringResource(R.string.content_description_sentiment_dissatisfied)
        )
    }
}