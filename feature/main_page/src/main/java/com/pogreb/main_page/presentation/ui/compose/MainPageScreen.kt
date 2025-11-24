package com.pogreb.main_page.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.design.R
import com.pogreb.design.component.ActionTopBar
import com.pogreb.design.component.FullScreenProgressIndicator
import com.pogreb.main_page.presentation.state.MainPageState
import com.pogreb.main_page.presentation.viewmodel.MainPageViewModel

@Composable
internal fun MainPageScreen(
    viewModel: MainPageViewModel,
    onQuestionClick: () -> Unit,
    onContinueClick: (Double, Int, Long) -> Unit,
    onViewAllClick: () -> Unit,
    onItemClick: (Long) -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }

    Scaffold(
        topBar = {
            ActionTopBar(
                title = stringResource(R.string.title_main_page),
                iconPainter = painterResource(R.drawable.question),
                contentDescription = stringResource(R.string.content_description_onboarding),
                onActionClick = onQuestionClick,
            )
        },
        content = { paddingValues ->
            when (val currentState = state) {
                is MainPageState.Content -> MainPageContent(
                    modifier = Modifier
                        .padding(paddingValues),
                    loanAmount = currentState.loanAmount,
                    maxAmount = currentState.loanConditions.maxAmount,
                    percent = currentState.loanConditions.percent,
                    period = currentState.loanConditions.period,
                    errorTextLoanCondition = currentState.errorTextConditions,
                    errorTextLoans = currentState.errorTextLoans,
                    onRetryLoadLoansClick = viewModel::refreshLoans,
                    onRetryLoadConditionClick = viewModel::refreshLoanCondition,
                    onSliderValueChange = { viewModel.updateLoanAmount(it) },
                    onContinueClick = {
                        onContinueClick(
                            currentState.loanConditions.percent,
                            currentState.loanConditions.period,
                            currentState.loanAmount,
                        )
                    },
                    onViewAllClick = onViewAllClick,
                    loans = currentState.loans,
                    onItemClick = onItemClick,
                )

                is MainPageState.Loading -> FullScreenProgressIndicator()
            }
        },
    )
}