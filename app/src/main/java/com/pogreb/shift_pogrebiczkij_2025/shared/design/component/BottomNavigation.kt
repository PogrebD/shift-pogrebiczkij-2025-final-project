package com.pogreb.shift_pogrebiczkij_2025.shared.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.bgDisable
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.iconPrimary

private const val PAGE_COUNT = 3

@Composable
fun BottomNavigation(
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    currentPage: Int,
) {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth(),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.outlineVariant
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BackTextButton(
            text = getBackButtonText(currentPage),
            modifier = Modifier
                .weight(1f),
            onBackClick = onBackClick,
        )

        PageStepper(
            modifier = Modifier
                .weight(1f),
            currentPage = currentPage,
        )

        NextTextButton(
            text = getNextButtonText(currentPage),
            modifier = Modifier
                .weight(1f),
            onNextClick = onNextClick,
        )
    }
}

@Composable
private fun NextTextButton(text: String, modifier: Modifier, onNextClick: () -> Unit) {
    Text(
        text = text,
        modifier = modifier
            .clickable(enabled = text.isNotEmpty(), onClick = onNextClick),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
private fun PageStepper(
    modifier: Modifier,
    currentPage: Int,
    pageCount: Int = PAGE_COUNT,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(getNavIconColor(currentPage, index))
            )
        }
    }
}

@Composable
private fun BackTextButton(text: String, modifier: Modifier, onBackClick: () -> Unit) {
    Text(
        text = text,
        modifier = modifier
            .clickable(enabled = true, onClick = onBackClick),
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
private fun getNavIconColor(currentPage: Int, index: Int) = when (index) {
    currentPage -> MaterialTheme.colorScheme.iconPrimary
    else -> MaterialTheme.colorScheme.bgDisable
}

@Composable
private fun getBackButtonText(currentPage: Int) = when (currentPage) {
    0 -> ""
    else -> stringResource(R.string.back_label)
}

@Composable
private fun getNextButtonText(currentPage: Int) = when (currentPage) {
    2 -> stringResource(R.string.close_label)
    else -> stringResource(R.string.next_label)
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewBottomNavigation() {
    AppTheme {
        BottomNavigation(
            onBackClick = {},
            onNextClick = {},
            currentPage = 2,
        )
    }
}