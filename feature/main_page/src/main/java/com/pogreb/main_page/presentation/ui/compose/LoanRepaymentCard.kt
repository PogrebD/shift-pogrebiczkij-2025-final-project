package com.pogreb.main_page.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.design.theme.AppTheme
import com.pogreb.main_page.R

@Composable
internal fun LoanRepaymentCard() {
    Box(
        modifier = Modifier
            .height(160.dp)
            .fillMaxWidth()
            .clip(ShapeDefaults.Large)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        LoanRepaymentCardText()

        LoanRepaymentCardGradient(
            modifier = Modifier
                .align(Alignment.CenterEnd)
        )
    }
}

@Composable
private fun LoanRepaymentCardText() {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, top = 27.dp)
    ) {
        Text(
            text = stringResource(R.string.loan_repayment_card_text_part_one),
            modifier = Modifier
                .padding(bottom = 4.dp),
            style = MaterialTheme.typography.headlineMedium,
        )

        Text(
            text = stringResource(R.string.loan_repayment_card_text_part_two),
            modifier = Modifier
                .padding(bottom = 12.dp),
            style = MaterialTheme.typography.headlineMedium,
        )

        Text(
            text = stringResource(R.string.loan_repayment_card_text_part_three),
            modifier = Modifier
                .padding(bottom = 2.dp),
            style = MaterialTheme.typography.bodyMedium,
        )

        Text(
            text = stringResource(R.string.loan_repayment_card_text_part_four),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun LoanRepaymentCardGradient(modifier: Modifier) {
    Box(
        modifier = modifier
            .offset(x = 86.dp)
            .rotate(-135f)
            .size(192.dp, 186.dp)
            .clip(ShapeDefaults.Large)
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f))
    )

    Box(
        modifier = modifier
            .offset(x = 124.dp)
            .rotate(-135f)
            .size(192.dp, 186.dp)
            .clip(ShapeDefaults.Large)
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f))
    )

    Box(
        modifier = modifier
            .offset(x = 162.dp)
            .rotate(-135f)
            .size(192.dp, 186.dp)
            .clip(ShapeDefaults.Large)
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.9f))
    )
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewAddCard() {
    AppTheme {
        LoanRepaymentCard()
    }
}