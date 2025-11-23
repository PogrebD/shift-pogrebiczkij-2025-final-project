package com.pogreb.shift_pogrebiczkij_2025.shared.design.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.pogreb.shift_pogrebiczkij_2025.R

@Composable
fun ErrorDialog(
    message: String,
    onRetry: () -> Unit,
    onCancel: () -> Unit,
) {
    if (message.isNotEmpty())
        AlertDialog(
            onDismissRequest = onCancel,
            title = { Text(text = stringResource(id = R.string.title_error)) },
            text = { Text(text = message) },
            confirmButton = {
                TextButton(onClick = onRetry) {
                    Text(text = stringResource(R.string.label_try_again))
                }
            },
            dismissButton = {
                TextButton(onClick = onCancel) {
                    Text(text = stringResource(R.string.label_cancel))
                }
            },
            containerColor = MaterialTheme.colorScheme.background
        )
}