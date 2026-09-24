package com.example.composetutorial.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/** A single to-do item. A plain `data class` - no Compose or Android types needed. */
data class Task(val title: String, val done: Boolean = false)

/**
 * LazyColumn is Compose's equivalent of RecyclerView: it only composes and
 * lays out the items currently visible on screen, which is what makes it
 * efficient for long or unbounded lists. Never use a plain Column with a
 * for-loop for lists that can grow large.
 */
@Composable
fun TaskList(modifier: Modifier = Modifier) {
    // mutableStateListOf gives you an observable MutableList: adding,
    // removing, or replacing elements triggers recomposition automatically.
    val tasks = remember {
        mutableStateListOf(
            Task("Learn Composable functions"),
            Task("Understand state & recomposition"),
            Task("Build a layout with Modifiers"),
            Task("Try Material 3 components")
        )
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp)
    ) {
        items(tasks) { task ->
            TaskRow(
                task = task,
                onToggle = {
                    val index = tasks.indexOf(task)
                    if (index != -1) tasks[index] = task.copy(done = !task.done)
                }
            )
        }
    }
}

@Composable
private fun TaskRow(task: Task, onToggle: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = task.done, onCheckedChange = { onToggle() })
            Text(
                text = task.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 300)
@Composable
private fun TaskListPreview() {
    ComposeTutorialTheme {
        TaskList()
    }
}
