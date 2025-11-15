package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
internal fun MainPageContent(
    modifier: Modifier,
    loanAmount: Double,
    maxAmount: Double,
    percent: Double,
    period: Int,
    onSliderValueChange: (Float) -> Unit,
    onContinueClick: () -> Unit,
) {

    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LoanRepaymentCard()

        Title(
            text = stringResource(R.string.title_loan_amount),
        )

        LoanCalculatorCard(
            loanAmount = loanAmount,
            maxAmount = maxAmount,
            percent = percent,
            period = period,
            onSliderValueChange = onSliderValueChange,
            onContinueClick = onContinueClick,
        )

        Title(
            text = stringResource(R.string.title_my_loans),
        )

        MyLoansList()
    }
}

@Composable
private fun Title(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.headlineMedium,
    )
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewMainPageContent() {
    AppTheme {
        MainPageContent(
            loanAmount = 7000.00,
            maxAmount = 10000.00,
            onSliderValueChange = {},
            percent = 30.0,
            period = 12,
            onContinueClick = {},
            modifier = Modifier,
        )
    }
}