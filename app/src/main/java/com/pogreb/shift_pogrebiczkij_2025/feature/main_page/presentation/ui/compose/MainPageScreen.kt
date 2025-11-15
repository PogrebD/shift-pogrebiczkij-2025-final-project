package com.pogreb.shift_pogrebiczkij_2025.feature.main_page.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.component.TabBar

@Composable
fun MainPageScreen() {

    Scaffold(
        topBar = {
            MainPageTopBar(
                onQuestionClick = TODO()
            )
        },
        content = { paddingValues ->
            MainPageContent(
                modifier = Modifier
                    .padding(paddingValues),
                loanAmount = TODO(),
                maxAmount = TODO(),
                percent = TODO(),
                period = TODO(),
                onSliderValueChange = TODO(),
                onContinueClick = TODO()
            )
        },
        bottomBar = {
            TabBar(
                onMainPageClick = TODO(),
                onMenuPageClick = TODO(),
                activeTab = TODO()
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPageTopBar(onQuestionClick: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(R.string.title_main_page)) },
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