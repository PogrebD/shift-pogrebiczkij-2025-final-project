package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.ui.compose

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.shift_pogrebiczkij_2025.R

@Composable
internal fun LoanProcessingScreen(
) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoanProcessingTopBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(R.string.title_loan_processing)) },
        navigationIcon = {
            IconButton(
                onClick = onBackClick,
                content = {
                    Icon(
                        painterResource(R.drawable.arrow_left),
                        contentDescription = stringResource(R.string.content_description_back)
                    )
                }
            )
        }
    )
}