package com.example.composetutorial.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * The simplest possible composable: it takes data in through parameters
 * and emits UI. No internal state, no side effects - call it "stateless".
 *
 * @param name text shown as the greeting target.
 * @param modifier lets the CALLER control layout (size, padding, clicks...)
 *        without GreetingCard needing to know about any of that. Every
 *        composable that draws something should accept a Modifier like this.
 */
@Composable
fun GreetingCard(name: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hello,",
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

// A @Preview composable is never shipped in the app; Android Studio uses it
// to render this one component in the "Design" pane without running the
// whole app or a device/emulator.
@Preview(showBackground = true)
@Composable
private fun GreetingCardPreview() {
    ComposeTutorialTheme {
        GreetingCard(name = "Jetpack Compose")
    }
}
