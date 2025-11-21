package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.domain.entity.Loan
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanElement
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.LoanStatus
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
internal fun LoanHistoryContent(
    modifier: Modifier,
    loans: List<Loan>,
    onItemClick: (Long) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(
            items = loans,
            key = { loan -> loan.id }
        ) { loan ->
            LoanElement(
                id = loan.id,
                amount = loan.amount,
                status = loan.status,
                date = loan.date,
                onItemClick = onItemClick,
            )
        }
    }
}


@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFF654345
)
@Composable
private fun PreviewLoanHistoryContent() {
    AppTheme {
        LoanHistoryContent(
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
            onItemClick = {},
            modifier = Modifier,
        )
    }
}