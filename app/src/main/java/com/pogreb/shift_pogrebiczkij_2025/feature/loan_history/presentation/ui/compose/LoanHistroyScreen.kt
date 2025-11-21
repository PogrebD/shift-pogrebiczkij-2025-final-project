package com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.ui.compose

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.state.LoanHistoryState
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_history.presentation.viewmodel.LoanHistoryViewModel
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.ActiveTab
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.TabBar

@Composable
internal fun LoanHistoryScreen(
    viewModel: LoanHistoryViewModel,
    onItemClick: (Long) -> Unit,
    onBackClick: () -> Unit,
    onMenuPageClick: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }

    Scaffold(
        topBar = {
            LoanHistoryTopBar(
                title = stringResource(R.string.title_my_loans),
                iconPainter = painterResource(R.drawable.arrow_left),
                onNavigationClick = onBackClick,
            )
        },
        content = { paddingValues ->
            when (val currentState = state) {
                is LoanHistoryState.Content -> LoanHistoryContent(
                    modifier = Modifier
                        .padding(paddingValues),
                    loans = currentState.loans,
                    onItemClick = onItemClick,
                )
            }
        },
        bottomBar = {
            TabBar(
                onMenuPageClick = onMenuPageClick,
                activeTab = ActiveTab.HOME,
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoanHistoryTopBar(
    title: String,
    iconPainter: Painter,
    onNavigationClick: () -> Unit
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = onNavigationClick,
                content = {
                    Icon(
                        painter = iconPainter,
                        contentDescription = stringResource(R.string.content_description_back)
                    )
                }
            )
        }
    )
}