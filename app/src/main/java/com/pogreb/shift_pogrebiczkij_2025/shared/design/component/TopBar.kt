package com.pogreb.shift_pogrebiczkij_2025.shared.design.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.iconSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationTopBar(
    title: String,
    iconPainter: Painter,
    contentDescription: String,
    onNavigationClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onNavigationClick,
                content = {
                    Icon(
                        painter = iconPainter,
                        contentDescription = contentDescription,
                        tint = MaterialTheme.colorScheme.iconSecondary,
                    )
                }
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionTopBar(
    title: String,
    iconPainter: Painter,
    contentDescription: String,
    onActionClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )
        },
        actions = {
            IconButton(
                onClick = onActionClick,
                content = {
                    Icon(
                        painter = iconPainter,
                        contentDescription = contentDescription,
                        tint = MaterialTheme.colorScheme.iconSecondary,
                    )
                }
            )
        }
    )
}