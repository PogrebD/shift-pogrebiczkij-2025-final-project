package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.ErrorDialog
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.InputErrorType
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.OutlinedInput
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.PhoneInput
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.PrimaryButton
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
internal fun LoanProcessingContent(
    modifier: Modifier,
    name: String,
    lastName: String,
    phone: String,
    nameErrorType: InputErrorType,
    lastNameErrorType: InputErrorType,
    phoneErrorType: InputErrorType,
    errorMessage: String,
    buttonEnabled: Boolean,
    onRefresh: () -> Unit,
    onCancel: () -> Unit,
    onNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onApplyLoanClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            YourDataTitle()

            OutlinedInput(
                label = stringResource(R.string.label_name),
                text = name,
                onValueChange = onNameChange,
                errorType = nameErrorType
            )

            OutlinedInput(
                label = stringResource(R.string.label_lastname),
                text = lastName,
                onValueChange = onLastNameChange,
                errorType = lastNameErrorType
            )

            PhoneInput(
                label = stringResource(R.string.label_phone),
                text = phone,
                errorType = phoneErrorType,
                onValueChange = onPhoneChange,
            )

            Description()
        }

        PrimaryButton(
            onClick = onApplyLoanClick,
            text = stringResource(R.string.label_apply_loan),
            modifier = Modifier
                .padding(top = 16.dp),
            enabled = buttonEnabled,
        )

        ErrorDialog(
            message = errorMessage,
            onRetry = onRefresh,
            onCancel = onCancel,
        )
    }
}

@Composable
private fun YourDataTitle() {
    Text(
        text = stringResource(R.string.title_your_data),
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Composable
private fun Description() {
    Text(
        text = stringResource(R.string.body_loan_processing),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.bodySmall,
    )
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewLoanProcessingContent() {
    AppTheme {
        LoanProcessingContent(
            name = "",
            lastName = "",
            phone = "",
            onNameChange = {},
            onLastNameChange = {},
            onPhoneChange = {},
            onApplyLoanClick = {},
            modifier = Modifier,
            nameErrorType = InputErrorType.NONE,
            lastNameErrorType = InputErrorType.NONE,
            phoneErrorType = InputErrorType.NONE,
            errorMessage = "",
            onRefresh = {},
            onCancel = {},
            buttonEnabled = true,
        )
    }
}