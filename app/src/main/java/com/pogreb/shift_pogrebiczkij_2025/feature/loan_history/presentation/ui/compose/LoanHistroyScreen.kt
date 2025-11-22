package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.ui.compose

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
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.state.LoanHistoryState
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.viewmodel.LoanHistoryViewModel
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.NavigationTopBar

@Composable
internal fun LoanHistoryScreen(
    viewModel: LoanHistoryViewModel,
    onItemClick: (Long) -> Unit,
    onBackClick: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }

    Scaffold(
        topBar = {
            NavigationTopBar(
                title = stringResource(R.string.title_my_loans),
                iconPainter = painterResource(R.drawable.arrow_left),
                onNavigationClick = onBackClick,
                contentDescription = stringResource(R.string.content_description_back),
            )
        },
        content = { paddingValues ->
            when (val currentState = state) {
                is LoanHistoryState.Content -> LoanHistoryContent(
                    modifier = Modifier
                        .padding(paddingValues),
                    loans = currentState.loans,
                    isRefreshing = currentState.isRefreshing,
                    onItemClick = onItemClick,
                    onRefresh = viewModel::refresh,
                )
            }
        },
    )
}