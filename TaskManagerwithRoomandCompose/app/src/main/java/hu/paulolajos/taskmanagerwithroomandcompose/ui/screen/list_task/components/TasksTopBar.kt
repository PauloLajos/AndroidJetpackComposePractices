package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.TASKS_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksTopBar() {
    TopAppBar (
        title = {
            Text(
                text = TASKS_SCREEN
            )
        }
    )
}