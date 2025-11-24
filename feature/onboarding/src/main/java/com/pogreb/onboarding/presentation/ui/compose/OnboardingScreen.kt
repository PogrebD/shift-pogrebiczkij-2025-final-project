package com.pogreb.onboarding.presentation.ui.compose

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
import com.pogreb.design.component.BottomNavigation
import com.pogreb.design.component.NavigationTopBar
import com.pogreb.onboarding.presentation.state.OnboardingState
import com.pogreb.onboarding.presentation.viewmodel.OnboardingViewModel

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
                NavigationTopBar(
                    title = "",
                    iconPainter = painterResource(R.drawable.cross),
                    contentDescription = stringResource(R.string.content_description_close),
                    onNavigationClick = onCloseClick,
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