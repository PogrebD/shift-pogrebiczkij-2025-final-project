package com.pogreb.shift_pogrebiczkij_2025.shared.design.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.shift_pogrebiczkij_2025.R
import com.pogreb.shift_pogrebiczkij_2025.shared.design.theme.AppTheme

@Composable
fun TabBar(
    onMainPageClick: () -> Unit,
    onMenuPageClick: () -> Unit,
    activeTab: ActiveTab,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MainPageNavigationElement(
            onMainPageClick = onMainPageClick,
            color = getMainPageTextColor(
                activeTab = activeTab
            )
        )

        MenuPageNavigationElement(
            onMenuPageClick = onMenuPageClick,
            color = getMenuPageTextColor(
                activeTab = activeTab
            )
        )
    }
}

@Composable
fun MenuPageNavigationElement(onMenuPageClick: () -> Unit, color: Color) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clickable(
                onClick = onMenuPageClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.menu),
            contentDescription = stringResource(R.string.content_description_menu_page_navigation),
            tint = color,
        )

        Text(
            text = stringResource(R.string.label_menu_page),
            color = color,
        )
    }
}

@Composable
fun MainPageNavigationElement(onMainPageClick: () -> Unit, color: Color) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clickable(
                onClick = onMainPageClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(R.drawable.home),
            contentDescription = stringResource(R.string.content_description_home_page_navigation),
            tint = color,
        )

        Text(
            text = stringResource(R.string.label_main_page),
            color = color,
        )
    }
}

@Composable
fun getMainPageTextColor(
    activeTab: ActiveTab,
) = when (activeTab) {
    ActiveTab.HOME ->
        MaterialTheme.colorScheme.secondary

    ActiveTab.MENU ->
        MaterialTheme.colorScheme.onSurfaceVariant
}

@Composable
fun getMenuPageTextColor(
    activeTab: ActiveTab,
) = when (activeTab) {
    ActiveTab.HOME ->
        MaterialTheme.colorScheme.onSurfaceVariant

    ActiveTab.MENU ->
        MaterialTheme.colorScheme.secondary
}

enum class ActiveTab {
    HOME, MENU
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun PreviewTabBar() {
    AppTheme {
        TabBar(
            onMainPageClick = {},
            onMenuPageClick = {},
            activeTab = ActiveTab.HOME,
        )
    }
}