package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
fun MyLoansList() {
    Column {
        Text(
            text = stringResource(R.string.body_my_loans),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewMyLoansList() {
    AppTheme {
        MyLoansList()
    }
}