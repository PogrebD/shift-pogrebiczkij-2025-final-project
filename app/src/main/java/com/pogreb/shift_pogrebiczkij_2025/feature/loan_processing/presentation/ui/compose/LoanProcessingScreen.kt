package com.pogreb.shift_pogrebiczkij_2025.feature.loan_processing.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.NavigationTopBar

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

    Scaffold(
        topBar = {
            when (state) {
                is LoanProcessingState.Content -> NavigationTopBar(
                    title = stringResource(R.string.title_loan_processing),
                    iconPainter = painterResource(R.drawable.arrow_left),
                    onNavigationClick = onCloseClick,
                    contentDescription = stringResource(R.string.content_description_back),
                )

                else -> NavigationTopBar(
                    title = "",
                    iconPainter = painterResource(R.drawable.cross),
                    onNavigationClick = onCloseClick,
                    contentDescription = stringResource(R.string.content_description_close),
                )
            }
        },
        content = { paddingValues ->
            when (val currentState = state) {
                is LoanProcessingState.Content ->
                    LoanProcessingContent(
                        modifier = Modifier
                            .padding(paddingValues),
                        name = currentState.userData.name,
                        lastName = currentState.userData.lastName,
                        phone = currentState.userData.phone,
                        nameErrorType = currentState.nameErrorType,
                        lastNameErrorType = currentState.lastNameErrorType,
                        phoneErrorType = currentState.phoneErrorType,
                        errorMessage = currentState.errorMassage,
                        onNameChange = viewModel::updateName,
                        onLastNameChange = viewModel::updateLastName,
                        onPhoneChange = viewModel::updatePhone,
                        onApplyLoanClick = viewModel::createLoan,
                        onRefresh = viewModel::refreshCreateLoan,
                        onCancel = viewModel::clearDialog,
                        buttonEnabled = viewModel.getAvailabilityApplyButton(),
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
        },
    )
}