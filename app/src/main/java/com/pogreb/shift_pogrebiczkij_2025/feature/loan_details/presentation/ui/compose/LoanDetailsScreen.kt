package com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.ui.compose

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
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.state.LoanDetailsState
import com.pogreb.shift_pogrebiczkij_2025.feature.loan_details.presentation.viewmodel.LoanDetailsViewModel
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.ActiveTab
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.TabBar

@Composable
internal fun LoanDetailsScreen(
    viewModel: LoanDetailsViewModel,
    id: Long,
    onBackClick: () -> Unit,
    onMenuPageClick: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize(id)
    }

    Scaffold(
        topBar = {
            LoanDetailsTopBar(
                title = stringResource(R.string.pattern_loan_number, id),
                iconPainter = painterResource(R.drawable.arrow_left),
                onNavigationClick = onBackClick,
            )
        },
        content = { paddingValues ->
            when (val currentState = state) {
                is LoanDetailsState.Content -> LoanDetailsContent(
                    modifier = Modifier
                        .padding(paddingValues),
                    amount = currentState.loanDetails.amount,
                    date = currentState.loanDetails.date,
                    name = currentState.loanDetails.name,
                    id = currentState.loanDetails.id,
                    lastName = currentState.loanDetails.lastName,
                    percent = currentState.loanDetails.percent,
                    period = currentState.loanDetails.period,
                    phone = currentState.loanDetails.phone,
                    status = currentState.loanDetails.status,
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
private fun LoanDetailsTopBar(
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