package com.pogreb.loan_history.presentation.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.design.component.ErrorDialog
import com.pogreb.design.component.LoanElement
import com.pogreb.design.component.LoanStatus
import com.pogreb.design.theme.AppTheme
import com.pogreb.loan_history.domain.entity.Loan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoanHistoryContent(
    modifier: Modifier,
    loans: List<Loan>,
    isRefreshing: Boolean,
    errorMessage: String,
    onItemClick: (Long) -> Unit,
    onRefresh: () -> Unit,
    onCancel: () -> Unit,
) {
    val refreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = refreshState,
        modifier = modifier
            .fillMaxSize(),
    ) {
        LoansList(
            loans = loans,
            onItemClick = onItemClick,
        )

        ErrorDialog(
            message = errorMessage,
            onRetry = onRefresh,
            onCancel = onCancel,
        )
    }
}

@Composable
private fun LoansList(loans: List<Loan>, onItemClick: (Long) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp),
    ) {
        items(
            items = loans,
            key = { loan -> loan.id },
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
            isRefreshing = false,
            onRefresh = {},
            errorMessage = "",
            onCancel = {},
        )
    }
}