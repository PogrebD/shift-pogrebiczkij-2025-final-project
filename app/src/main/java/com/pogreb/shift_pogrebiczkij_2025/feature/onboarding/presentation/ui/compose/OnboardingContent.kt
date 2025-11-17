package com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.compose

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
internal fun OnboardingContent(
    modifier: Modifier,
    currentPage: Int
) {
    Crossfade(targetState = currentPage) { currentPage ->
        when (currentPage) {
            0 -> Content(
                modifier = modifier,
                illustration = painterResource(R.drawable.opening_illustration),
                titleInstruction = stringResource(R.string.title_create_loan),
                bodyInstruction = stringResource(R.string.body_create_loan),
            )

            1 -> ContentWithAnnotatedInstruction(
                modifier = modifier,
                illustration = painterResource(R.drawable.second_illustration),
                titleInstruction = stringResource(R.string.title_get_loan),
            )

            2 -> Content(
                modifier = modifier,
                illustration = painterResource(R.drawable.closing_illuctration),
                titleInstruction = stringResource(R.string.title_Issued_loans),
                bodyInstruction = stringResource(R.string.body_Issued_loans),
            )
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier,
    illustration: Painter,
    titleInstruction: String,
    bodyInstruction: String
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Image(
            painter = illustration,
            contentDescription = "",
            modifier = Modifier
                .size(360.dp, 320.dp),
        )

        LaonInstructions(
            title = titleInstruction,
            body = bodyInstruction,
        )
    }
}

@Composable
private fun ContentWithAnnotatedInstruction(
    modifier: Modifier,
    illustration: Painter,
    titleInstruction: String
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Image(
            painter = illustration,
            contentDescription = "",
            modifier = Modifier
                .size(360.dp, 320.dp),
        )

        LaonInstructionsWithAnnotation(
            title = titleInstruction,
        )
    }
}

@Composable
private fun LaonInstructions(title: String, body: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge,
    )

    Text(
        text = body,
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Composable
private fun LaonInstructionsWithAnnotation(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge,
    )

    Text(
        buildAnnotatedString {
            append(stringResource(R.string.body_start_issued_loans))

            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.inversePrimary)) {
                append(stringResource(R.string.body_annotation_issued_loans))
            }

            append(stringResource(R.string.body_end_issued_loans))
        },
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewOnboardingContent() {
    AppTheme {
        OnboardingContent(
            currentPage = 0,
            modifier = Modifier
        )
    }
}