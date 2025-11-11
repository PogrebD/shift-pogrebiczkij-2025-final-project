package com.pogreb.shift_pogrebiczkij_2025.shared.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalCustomColorScheme = staticCompositionLocalOf { LightCustomColorScheme }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val customColors = if (darkTheme) DarkCustomColorScheme else LightCustomColorScheme

    val materialColorScheme = ColorScheme(
        primary = customColors.primary,
        onPrimary = customColors.onPrimary,
        primaryContainer = customColors.primaryContainer,
        onPrimaryContainer = customColors.onPrimaryContainer,
        inversePrimary = customColors.inversePrimary,
        secondary = customColors.secondary,
        onSecondary = customColors.onSecondary,
        secondaryContainer = customColors.secondaryContainer,
        onSecondaryContainer = customColors.onSecondaryContainer,
        tertiary = customColors.tertiary,
        onTertiary = customColors.onTertiary,
        tertiaryContainer = customColors.tertiaryContainer,
        onTertiaryContainer = customColors.onTertiaryContainer,
        background = customColors.background,
        onBackground = customColors.onBackground,
        surface = customColors.surface,
        onSurface = customColors.onSurface,
        surfaceVariant = customColors.surfaceVariant,
        onSurfaceVariant = customColors.onSurfaceVariant,
        surfaceTint = customColors.surfaceTint,
        inverseSurface = customColors.inverseSurface,
        inverseOnSurface = customColors.inverseOnSurface,
        error = customColors.error,
        onError = customColors.onError,
        errorContainer = customColors.errorContainer,
        onErrorContainer = customColors.onErrorContainer,
        outline = customColors.outline,
        outlineVariant = customColors.outlineVariant,
        scrim = customColors.scrim,
    )

    CompositionLocalProvider(
        LocalCustomColorScheme provides customColors
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = Typography,
            content = content
        )
    }
}