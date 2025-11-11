package com.pogreb.shift_pogrebiczkij_2025.shared.design.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PermanentPrimary,
    onPrimary = FontNightPrimary,
    primaryContainer = PermanentPrimaryLight,
    onPrimaryContainer = FontNightPrimary,
    inversePrimary = PermanentPrimaryDark,

    background = BgNightPrimary,
    onBackground = FontNightPrimary,
    surface = BgNightPrimary,
    onSurface = FontNightPrimary,
    surfaceVariant = BgNightSecondary,
    onSurfaceVariant = FontNightSecondary,

    error = IndicatorNightError,
    onError = FontNightPrimaryInvert,
    tertiary = IndicatorNightPositive,
    onTertiary = FontNightPrimaryInvert,

    outline = BorderNightPrimary,
    outlineVariant = BorderNightSecondary,

    surfaceDim = BgNightTertiary,
    surfaceBright = BgNightPrimary,
)

private val LightColorScheme = lightColorScheme(
    primary = PermanentPrimary,
    onPrimary = FontDayPrimary,
    primaryContainer = PermanentPrimaryLight,
    onPrimaryContainer = FontDayPrimary,
    inversePrimary = PermanentPrimaryDark,

    background = BgDayPrimary,
    onBackground = FontDayPrimary,
    surface = BgDayPrimary,
    onSurface = FontDayPrimary,
    surfaceVariant = BgDaySecondary,
    onSurfaceVariant = FontDaySecondary,

    error = IndicatorDayError,
    onError = FontDayPrimaryInvert,
    tertiary = IndicatorDayPositive,
    onTertiary = FontDayPrimaryInvert,

    outline = BorderDayPrimary,
    outlineVariant = BorderDaySecondary,

    surfaceDim = BgDayTertiary,
    surfaceBright = BgDayPrimary,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}