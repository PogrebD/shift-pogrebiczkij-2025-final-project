package com.pogreb.bank_addresses.presentation.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pogreb.design.R
import com.pogreb.design.component.NavigationTopBar

@Composable
internal fun BankAddressesScreen(
    onBackToMainClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            NavigationTopBar(
                title = "",
                iconPainter = painterResource(R.drawable.cross),
                onNavigationClick = onBackToMainClick,
                contentDescription = stringResource(R.string.content_description_close),
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