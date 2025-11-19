package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.state.LoanProcessingState
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.viewmodel.LoanProcessingViewModel

@Composable
internal fun LoanProcessingScreen(
    viewModel: LoanProcessingViewModel,
    percent: Double,
    period: Int,
    amount: Long,
    onCloseClick: () -> Unit,
    onViewAddressClick: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize(
            percent = percent,
            period = period,
            amount = amount,
        )
    }

    Scaffold { paddingValues ->
        when (val currentState = state) {
            is LoanProcessingState.Content ->
                LoanProcessingContent(
                    modifier = Modifier
                        .padding(paddingValues),
                    name = currentState.userData.name,
                    lastName = currentState.userData.lastName,
                    phone = currentState.userData.phone,
                    onNameChange = viewModel::updateName,
                    onLastNameChange = viewModel::updateLastName,
                    onPhoneChange = viewModel::updatePhone,
                    onApplyLoanClick = viewModel::createLoan,
                )

            is LoanProcessingState.SuccessfulResult ->
                SuccessfulContent(
                    modifier = Modifier
                        .padding(paddingValues),
                    amount = currentState.amount,
                    date = currentState.date,
                    onViewAddressClick = onViewAddressClick,
                )

            is LoanProcessingState.FailureResult ->
                FailureContent(
                    modifier = Modifier
                        .padding(paddingValues),
                    onBackMainClick = onCloseClick,
                )
        }
    }
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