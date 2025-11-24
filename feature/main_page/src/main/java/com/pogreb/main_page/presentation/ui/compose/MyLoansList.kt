package com.pogreb.main_page.presentation.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.design.R
import com.pogreb.design.component.LoanElement
import com.pogreb.design.component.LoanStatus
import com.pogreb.design.component.SecondaryButton
import com.pogreb.design.theme.AppTheme
import com.pogreb.main_page.domain.entity.Loan

@Composable
internal fun MyLoansList(
    loans: List<Loan>,
    errorTextLoans: String,
    onRetryClick: () -> Unit,
    onViewAllClick: () -> Unit,
    onItemClick: (Long) -> Unit,
) {
    if (loans.isEmpty() && errorTextLoans.isEmpty()) {
        EmptyLoans()
    } else {
        LoansCard(
            loans = loans,
            onViewAllClick = onViewAllClick,
            errorTextLoans = errorTextLoans,
            onRetryClick = onRetryClick,
            onItemClick = onItemClick,
        )
    }
}

@Composable
private fun LoansCard(
    loans: List<Loan>,
    errorTextLoans: String,
    onRetryClick: () -> Unit,
    onViewAllClick: () -> Unit,
    onItemClick: (Long) -> Unit,
) {
    Card(
        modifier = Modifier,
        shape = ShapeDefaults.Large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        if (errorTextLoans.isEmpty()) {
            MyLoansListContent(
                loans = loans,
                onViewAllClick = onViewAllClick,
                onItemClick = onItemClick,
            )
        } else {
            ErrorCardContent(
                error = errorTextLoans,
                onRetryClick = onRetryClick,
            )
        }
    }
}

@Composable
private fun MyLoansListContent(
    loans: List<Loan>,
    onViewAllClick: () -> Unit,
    onItemClick: (Long) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        LoansList(
            loans = loans,
            onItemClick = onItemClick,
        )

        SecondaryButton(
            onClick = onViewAllClick,
            text = stringResource(R.string.label_view_all),
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}

@Composable
private fun LoansList(
    loans: List<Loan>,
    onItemClick: (Long) -> Unit,
) {
    loans.forEach { loan ->
        LoanElement(
            id = loan.id,
            amount = loan.amount,
            status = loan.status,
            date = loan.date,
            onItemClick = onItemClick,
        )
    }
}

@Composable
private fun EmptyLoans() {
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
    backgroundColor = 0xFF654345
)
@Composable
private fun PreviewMyLoansList() {
    AppTheme {
        MyLoansList(
            loans = listOf(
                Loan(
                    id = 176899134565,
                    amount = 10000,
                    date = "2025-11-17T10:15:41.464Z",
                    status = LoanStatus.APPROVED,
                ),
                Loan(
                    id = 176899134565,
                    amount = 10000,
                    date = "2025-12-17T10:15:41.464Z",
                    status = LoanStatus.REJECTED,
                ),
                Loan(
                    id = 176899134565,
                    amount = 10000,
                    date = "2021-11-11T10:15:41.464Z",
                    status = LoanStatus.REGISTERED,
                )
            ),
            onViewAllClick = {},
            onItemClick = {},
            errorTextLoans = "Увы",
            onRetryClick = {},
        )
    }
}