package com.pogreb.loan_processing.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.design.R
import com.pogreb.design.component.PrimaryButton
import com.pogreb.design.theme.AppTheme

@Composable
internal fun SuccessfulContent(
    modifier: Modifier,
    amount: Long,
    date: String,
    onViewAddressClick: () -> Unit,
) {
    ResultContent(
        modifier = modifier,
        title = stringResource(R.string.pattern_title_success, amount),
        description = stringResource(R.string.pattern_body_success, date),
        image = painterResource(R.drawable.s_success),
        buttonText = stringResource(R.string.label_view_address),
        contentDescription = stringResource(R.string.content_description_success),
        onButtonClick = onViewAddressClick
    )
}

@Composable
internal fun FailureContent(
    modifier: Modifier,
    onBackMainClick: () -> Unit,
) {
    ResultContent(
        modifier = modifier,
        title = stringResource(R.string.title_failure),
        description = stringResource(R.string.body_failure),
        image = painterResource(R.drawable.s_some_error),
        buttonText = stringResource(R.string.label_back_main),
        contentDescription = stringResource(R.string.content_description_failure),
        onButtonClick = onBackMainClick
    )
}


@Composable
private fun ResultContent(
    modifier: Modifier,
    title: String,
    description: String,
    image: Painter,
    buttonText: String,
    contentDescription: String,
    onButtonClick: () -> Unit,
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .offset(y = (-64).dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = image,
                contentDescription = contentDescription,
                modifier = Modifier
                    .padding(bottom = 12.dp)
            )

            Text(
                text = title,
                modifier = Modifier
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
            )

            Text(
                text = description,
                modifier = Modifier
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        PrimaryButton(
            onClick = onButtonClick,
            text = buttonText,
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ResultTopBar(onCloseClick: () -> Unit) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(
                onClick = onCloseClick,
                content = {
                    Icon(
                        painterResource(R.drawable.cross),
                        contentDescription = stringResource(R.string.content_description_close)
                    )
                }
            )
        }
    )
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewSuccessfulScreen() {

    AppTheme {
        SuccessfulContent(
            amount = 50000,
            date = "20 мая",
            onViewAddressClick = {},
            modifier = Modifier,
        )
    }
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewFailureScreen() {

    AppTheme {
        FailureContent(
            modifier = Modifier,
            onBackMainClick = {},
        )
    }
}