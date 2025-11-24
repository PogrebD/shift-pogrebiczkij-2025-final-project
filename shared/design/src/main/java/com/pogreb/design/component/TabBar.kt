package com.pogreb.design.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
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
import com.pogreb.design.R
import com.pogreb.design.theme.AppTheme
import com.pogreb.design.theme.bgDisable

@Composable
fun TabBar(
    onMainPageClick: () -> Unit,
    onMenuPageClick: () -> Unit,
    activeTab: ActiveTab,
    activeTabBar: Boolean,
) {
    if (activeTabBar) {
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.bgDisable
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
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
}

@Composable
private fun MenuPageNavigationElement(onMenuPageClick: () -> Unit, color: Color) {
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
private fun MainPageNavigationElement(onMainPageClick: () -> Unit, color: Color) {
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
private fun getMainPageTextColor(
    activeTab: ActiveTab,
) = when (activeTab) {
    ActiveTab.HOME ->
        MaterialTheme.colorScheme.secondary

    ActiveTab.MENU ->
        MaterialTheme.colorScheme.onSurfaceVariant
}

@Composable
private fun getMenuPageTextColor(
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
private fun PreviewTabBar() {
    AppTheme {
        TabBar(
            onMainPageClick = {},
            onMenuPageClick = {},
            activeTab = ActiveTab.HOME,
            activeTabBar = true,
        )
    }
}