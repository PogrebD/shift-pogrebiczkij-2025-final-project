package com.pogreb.shift_pogrebiczkij_2025.feature.bank_addresses.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.shift_pogrebiczkij_2025.R

@Composable
fun BankAddressesScreen(
    onBackToMainClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            BankAddressesTopBar(
                title = "",
                iconPainter = painterResource(R.drawable.cross),
                onNavigationClick = onBackToMainClick
            )
        },
        content = { paddingValues ->
            BankAddressesContent(
                modifier = Modifier
                    .padding(paddingValues),
                onBackToMainClick = onBackToMainClick,
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BankAddressesTopBar(
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
                        contentDescription = stringResource(R.string.content_description_back_main)
                    )
                }
            )
        }
    )
}