package com.example.composetutorial.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * Demonstrates local, in-memory state and recomposition - the core idea
 * behind Compose's reactive model.
 *
 * `remember { mutableIntStateOf(0) }` creates a piece of observable state
 * that survives recomposition (but NOT configuration changes like screen
 * rotation - for that you'd use `rememberSaveable` instead).
 *
 * Reading `count` inside this function makes Compose track this composable
 * as a "reader". When `count` changes, ONLY this composable (and anything
 * that reads it) is re-invoked and redrawn - not the whole screen.
 */
@Composable
fun CounterButton(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }

    Row(modifier = modifier.padding(16.dp)) {
        Button(onClick = { count++ }) {
            Text("Tap me")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Clicked $count times",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CounterButtonPreview() {
    ComposeTutorialTheme {
        CounterButton()
    }
}
