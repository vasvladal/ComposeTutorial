package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.components.CounterButton
import com.example.composetutorial.components.GreetingCard
import com.example.composetutorial.components.ProfileForm
import com.example.composetutorial.components.TaskList
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * The single Activity that hosts the whole Compose UI (see the "single
 * Activity architecture" pattern - typical for Compose apps).
 *
 * Everything below setContent { ... } is Compose: no XML layouts, no
 * findViewById, no fragments involved.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Applying the theme once at the root makes MaterialTheme.colorScheme
            // and MaterialTheme.typography available to every composable below.
            ComposeTutorialTheme {
                TutorialApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorialApp() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Jetpack Compose Tutorial") })
        }
    ) { innerPadding ->
        // Surface paints the Material background color behind the content.
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                SectionLabel("1. A stateless composable")
                GreetingCard(
                    name = "Jetpack Compose",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                SectionLabel("2. State & recomposition")
                CounterButton()

                SectionLabel("3. State hoisting with a text field")
                ProfileForm()

                SectionLabel("4. Lists with LazyColumn")
                TaskList(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Column {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp, top = 20.dp, bottom = 4.dp)
        )
        HorizontalDivider()
    }
}

@Preview(showBackground = true, heightDp = 1200)
@Composable
private fun TutorialAppPreview() {
    ComposeTutorialTheme {
        TutorialApp()
    }
}
