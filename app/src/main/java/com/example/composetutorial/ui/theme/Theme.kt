package com.example.composetutorial.ui.theme

import android.app.Activity
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
    primary = PurpleDark,
    secondary = PurpleGreyDark,
    tertiary = PinkDark
)

private val LightColorScheme = lightColorScheme(
    primary = PurpleLight,
    secondary = PurpleGreyLight,
    tertiary = PinkLight
)

/**
 * App-wide theme. Wrap your top-level composable in this once (see MainActivity)
 * and every composable below it automatically picks up the right colors,
 * typography and shapes through MaterialTheme.
 */
@Composable
fun ComposeTutorialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+ and derives the palette
    // from the user's wallpaper.
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
        typography = AppTypography,
        content = content
    )
}
