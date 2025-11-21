package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.compose

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
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.Loan
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanElement
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.SecondaryButton
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
fun MyLoansList(
    loans: List<Loan>,
    onViewAllClick: () -> Unit,
    onItemClick: (Long) -> Unit,
) {
    if (loans.isEmpty()) {
        EmptyLoans()
    } else {
        LoansCard(
            loans = loans,
            onViewAllClick = onViewAllClick,
            onItemClick
        )
    }
}

@Composable
fun LoansCard(
    loans: List<Loan>,
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
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
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

            SecondaryButton(
                onClick = onViewAllClick,
                text = stringResource(R.string.label_view_all),
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun EmptyLoans() {
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
        )
    }
}