package com.pogreb.main_page.presentation.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pogreb.design.R
import com.pogreb.design.component.SecondaryButton

@Composable
internal fun ErrorCardContent(
    error: String,
    onRetryClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.outline_sentiment_dissatisfied_24),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = stringResource(R.string.content_description_sentiment_dissatisfied)
        )

        Text(
            text = error,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )

        SecondaryButton(
            onClick = onRetryClick,
            text = stringResource(R.string.label_try_again),
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}