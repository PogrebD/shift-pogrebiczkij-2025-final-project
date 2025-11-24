package com.pogreb.loan_details.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.design.R
import com.pogreb.design.component.LoanStatus
import com.pogreb.design.component.getStatusColor
import com.pogreb.design.component.getStatusText
import com.pogreb.design.theme.AppTheme

@Composable
internal fun LoanDetailsContent(
    modifier: Modifier,
    amount: Long,
    date: String,
    name: String,
    id: Long,
    lastName: String,
    percent: Double,
    period: Int,
    phone: String,
    status: LoanStatus,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        UserDetailsCard(
            name = name,
            lastName = lastName,
            phone = phone,
        )

        LoanDetailsCard(
            amount = amount,
            date = date,
            percent = percent,
            period = period,
            id = id,
        )

        Status(
            status = status,
        )

        Description(
            status = status,
        )
    }
}

@Composable
private fun UserDetailsCard(
    name: String,
    lastName: String,
    phone: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = ShapeDefaults.Large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(top = 6.dp, bottom = 4.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DetailsItem(
                label = stringResource(R.string.label_name),
                value = name,
            )

            DetailsItem(
                label = stringResource(R.string.label_lastname),
                value = lastName,
            )

            DetailsItem(
                label = stringResource(R.string.label_phone),
                value = phone,
            )
        }
    }
}

@Composable
private fun LoanDetailsCard(
    amount: Long,
    date: String,
    percent: Double,
    period: Int,
    id: Long,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = ShapeDefaults.Large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(top = 6.dp, bottom = 4.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DetailsItem(
                label = stringResource(R.string.label_id),
                value = stringResource(R.string.pattern_loan_number, id),
            )

            DetailsItem(
                label = stringResource(R.string.label_date),
                value = date,
            )

            DetailsItem(
                label = stringResource(R.string.label_period),
                value = period.toString(),
            )

            DetailsItem(
                label = stringResource(R.string.label_percent),
                value = stringResource(R.string.pattern_percent, percent.toString()),
            )

            DetailsItem(
                label = stringResource(R.string.label_amount),
                value = stringResource(R.string.pattern_amount, amount),
            )
        }
    }
}

@Composable
private fun Status(
    status: LoanStatus,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = ShapeDefaults.Large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
        ) {
            Text(
                text = stringResource(R.string.label_status),
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 4.dp, bottom = 6.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = getStatusText(status),
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 6.dp),
                color = getStatusColor(status),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun Description(status: LoanStatus) {
    Text(
        text = getDescriptionText(status),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
private fun getDescriptionText(status: LoanStatus) = when (status) {
    LoanStatus.REGISTERED -> stringResource(R.string.body_loan_details_registered)
    LoanStatus.APPROVED -> stringResource(R.string.body_loan_details_approved)
    LoanStatus.REJECTED -> stringResource(R.string.body_loan_details_rejected)
}

@Composable
private fun DetailsItem(
    label: String,
    value: String,
) {
    Row {
        Text(
            text = label,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewLoanDetailsContent() {
    AppTheme {
        LoanDetailsContent(
            modifier = Modifier,
            amount = 10000,
            date = "25.12.2020",
            name = "Иван",
            lastName = "Петров",
            percent = 12.0,
            period = 5,
            phone = "89231458890",
            status = LoanStatus.REGISTERED,
            id = 176899134565,
        )
    }
}