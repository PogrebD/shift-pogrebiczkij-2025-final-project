package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.state.MainPageState
import com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.viewmodel.MainPageViewModel

@Composable
internal fun MainPageScreen(
    viewModel: MainPageViewModel,
    onQuestionClick: () -> Unit,
    onMenuPageClick: () -> Unit,
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
            MainPageTopBar(
                onQuestionClick = onQuestionClick,
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
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainPageTopBar(onQuestionClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.title_main_page),
                style = MaterialTheme.typography.headlineMedium
            )
        },
        actions = {
            IconButton(
                onClick = onQuestionClick,
                content = {
                    Icon(
                        painterResource(R.drawable.question),
                        contentDescription = stringResource(R.string.close_content_description)
                    )
                }
            )
        }
    )
}