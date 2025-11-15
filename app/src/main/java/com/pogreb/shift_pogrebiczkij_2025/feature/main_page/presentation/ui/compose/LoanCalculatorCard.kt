package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.PrimaryButton
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.bgDisable
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.iconSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanCalculatorCard(
    loanAmount: Double,
    maxAmount: Double,
    percent: Double,
    period: Int,
    onSliderValueChange: (Float) -> Unit,
    onContinueClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        shape = ShapeDefaults.Large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Column {
            LoanAmount(
                loanAmount = loanAmount,
            )

            LoanAmountSlider(
                loanAmount = loanAmount,
                onSliderValueChange = onSliderValueChange,
                maxAmount = maxAmount,
            )

            LoanConditions(
                percent = percent,
                period = period,
            )

            PrimaryButton(
                onClick = onContinueClick,
                text = stringResource(R.string.label_continue),
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun LoanConditions(
    percent: Double,
    period: Int,
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = stringResource(R.string.label_conditions),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )

        Text(
            text = stringResource(
                R.string.pattern_percent_period_conditions,
                percent.toString(), period.toString()
            ),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanAmountSlider(loanAmount: Double, maxAmount: Double, onSliderValueChange: (Float) -> Unit) {
    Slider(
        value = loanAmount.toFloat(),
        onValueChange = onSliderValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.inverseSurface,
        ),
        thumb = {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = MaterialTheme.colorScheme.inverseSurface,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    painter = painterResource(R.drawable.small_arrow_left),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 5.dp)
                )

                Icon(
                    painter = painterResource(R.drawable.small_arrow_right),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 4.dp)
                )
            }
        },
        track = { sliderState ->
            SliderDefaults.Track(
                colors = SliderDefaults.colors(
                    activeTrackColor = MaterialTheme.colorScheme.inverseSurface,
                    inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                sliderState = sliderState,
                modifier = Modifier
                    .height(4.dp)
            )
        },
        valueRange = 0f..maxAmount.toFloat()
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.min_amount),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = stringResource(R.string.pattern_amount, maxAmount.toString()),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }

    HorizontalDivider(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 2.dp),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.bgDisable
    )
}

@Composable
fun LoanAmount(loanAmount: Double) {
    Row(
        modifier = Modifier.padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.pattern_amount, loanAmount.toString()),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium
        )

        Icon(
            painter = painterResource(
                R.drawable.edit
            ),
            contentDescription = stringResource(R.string.content_description_edit),
            tint = MaterialTheme.colorScheme.iconSecondary
        )
    }
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun PreviewAuthorizationContent() {
    AppTheme {
        LoanCalculatorCard(
            loanAmount = 7000.00,
            maxAmount = 10000.00,
            onSliderValueChange = {},
            percent = 30.0,
            period = 12,
            onContinueClick = {},
        )
    }
}