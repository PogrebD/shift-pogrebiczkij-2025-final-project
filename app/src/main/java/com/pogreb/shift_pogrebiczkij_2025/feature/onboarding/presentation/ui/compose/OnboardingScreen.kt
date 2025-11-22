package com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.state.OnboardingState
import com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.viewmodel.OnboardingViewModel
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.BottomNavigation

@Composable
internal fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    onCloseClick: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }

    when (val currentState = state) {

        is OnboardingState.Content -> Scaffold(
            topBar = {
                OnboardingTopBar(
                    onCloseClick = onCloseClick,
                )
            },
            content = {
                OnboardingContent(
                    modifier = Modifier.padding(it),
                    currentPage = currentState.pageNumber,
                )
            },
            bottomBar = {
                BottomNavigation(
                    currentPage = currentState.pageNumber,
                    onBackClick = viewModel::switchPreviousPage,
                    onNextClick = viewModel::switchNextPage,
                    onCloseClick = onCloseClick,
                )
            },
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OnboardingTopBar(onCloseClick: () -> Unit) {
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
        },
    )
}