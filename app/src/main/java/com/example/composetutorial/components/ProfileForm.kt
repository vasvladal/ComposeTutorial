package com.example.composetutorial.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * Shows a simple, one-way-bound text input: state lives outside the
 * TextField (in `remember { mutableStateOf(...) }`) and is fed back in
 * through `value` / `onValueChange`. This "state hoisting" pattern - the
 * composable doesn't own its own state, the caller does - is what makes
 * Compose UI predictable and easy to test.
 */
@Composable
fun ProfileForm(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Your name",
            style = MaterialTheme.typography.labelSmall
        )
        OutlinedTextField(
            value = text,
            onValueChange = { newValue -> text = newValue },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Type something...") },
            singleLine = true
        )
        if (text.isNotBlank()) {
            Text(
                text = "Nice to meet you, $text!",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileFormPreview() {
    ComposeTutorialTheme {
        ProfileForm()
    }
}
