package com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.pogreb.shift_pogrebiczkij_2025.R

data class MenuItem(
    val id: Int,
    @StringRes val titleResId: Int,
    @DrawableRes val iconResId: Int = R.drawable.arrow_right,
    val action: () -> Unit = {}
)