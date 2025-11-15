package com.pogreb.shift_pogrebiczkij_2025.feature.onboarding.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.BottomNavigation

@Composable
internal fun OnBoardingScreen() {

    Scaffold(
        topBar = {
            OnBoardingTopBar(
                onCloseClick = TODO()
            )
        },
        bottomBar = {
            BottomNavigation(
                onBackClick = TODO(),
                onNextClick = TODO(),
                currentPage = TODO()
            )
        },
        content = {
            OnBoardingContent(
                modifier = Modifier.padding(it),
                currentPage = TODO()
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OnBoardingTopBar(onCloseClick: () -> Unit) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(
                onClick = onCloseClick,
                content = {
                    Icon(
                        painterResource(R.drawable.cross),
                        contentDescription = stringResource(R.string.close_content_description)
                    )
                }
            )
        },
    )
}