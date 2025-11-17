package com.pogreb.shift_pogrebiczkij_2025.shared.design.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.indicatorAttention
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.indicatorPositive
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@Composable
fun LoanElement(id: Long, amount: Long, status: LoanStatus, date: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = stringResource(R.string.pattern_loan_number, id),
                style = MaterialTheme.typography.bodyLarge,
            )

            Text(
                text = getStatusText(status),
                color = getStatusColor(status),
                style = MaterialTheme.typography.bodySmall,
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = stringResource(R.string.pattern_amount, amount),
                style = MaterialTheme.typography.bodyLarge,
            )

            Text(
                text = formatDate(date),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

enum class LoanStatus {
    APPROVED,
    REGISTERED,
    REJECTED
}

@Composable
fun getStatusText(status: LoanStatus) = when (status) {
    LoanStatus.APPROVED -> stringResource(R.string.loan_status_approved)
    LoanStatus.REGISTERED -> stringResource(R.string.loan_status_registered)
    LoanStatus.REJECTED -> stringResource(R.string.loan_status_rejected)
}

@Composable
fun getStatusColor(status: LoanStatus) = when (status) {
    LoanStatus.APPROVED -> MaterialTheme.colorScheme.indicatorPositive
    LoanStatus.REGISTERED -> MaterialTheme.colorScheme.indicatorAttention
    LoanStatus.REJECTED -> MaterialTheme.colorScheme.error
}

@Composable
fun formatDate(isoDate: String): String = try {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")

    val outputFormat = SimpleDateFormat("d MMMM, EEE", Locale("ru"))

    val date = inputFormat.parse(isoDate)
    if (date != null) {
        outputFormat.format(date)
    } else {
        ""
    }
} catch (e: Exception) {
    stringResource(R.string.error_date_format)
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewLoan() {
    AppTheme {
        LoanElement(
            id = 176899134565,
            amount = 10000,
            date = "2025-11-17T10:15:41.464Z",
            status = LoanStatus.APPROVED,
        )
    }
}