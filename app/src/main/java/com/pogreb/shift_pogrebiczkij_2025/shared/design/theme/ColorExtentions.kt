package com.pogreb.shift_pogrebiczkij_2025.shared.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

val customColors: CustomColorScheme
    @Composable @ReadOnlyComposable
    get() = LocalCustomColorScheme.current

val androidx.compose.material3.ColorScheme.bgTertiary: Color
    @Composable @ReadOnlyComposable
    get() = customColors.bgTertiary

val androidx.compose.material3.ColorScheme.bgDisable: Color
    @Composable @ReadOnlyComposable
    get() = customColors.bgDisable

val androidx.compose.material3.ColorScheme.fontDisable: Color
    @Composable @ReadOnlyComposable
    get() = customColors.fontDisable

val androidx.compose.material3.ColorScheme.indicatorPositive: Color
    @Composable @ReadOnlyComposable
    get() = customColors.indicatorPositive

val androidx.compose.material3.ColorScheme.indicatorAttention: Color
    @Composable @ReadOnlyComposable
    get() = customColors.indicatorAttention

val androidx.compose.material3.ColorScheme.iconPrimary: Color
    @Composable @ReadOnlyComposable
    get() = customColors.iconPrimary

val androidx.compose.material3.ColorScheme.iconSecondary: Color
    @Composable @ReadOnlyComposable
    get() = customColors.iconSecondary

val androidx.compose.material3.ColorScheme.iconDisable: Color
    @Composable @ReadOnlyComposable
    get() = customColors.iconDisable

val androidx.compose.material3.ColorScheme.iconPrimaryInvert: Color
    @Composable @ReadOnlyComposable
    get() = customColors.iconPrimaryInvert