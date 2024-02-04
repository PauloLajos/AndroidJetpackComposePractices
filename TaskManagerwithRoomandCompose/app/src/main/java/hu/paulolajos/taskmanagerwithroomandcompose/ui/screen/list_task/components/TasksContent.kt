package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task
import hu.paulolajos.taskmanagerwithroomandcompose.domain.repository.Tasks
import androidx.compose.foundation.lazy.items

@Composable
fun TasksContent(
    padding: PaddingValues,
    tasks: Tasks,
    deleteTask: (task: Task) -> Unit,
    navigateToUpdateTaskScreen: (taskId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(
            items = tasks
        ) { task ->
            TaskCard(
                task = task,
                deleteTask = {
                    deleteTask(task)
                },
                navigateToUpdateTaskScreen = navigateToUpdateTaskScreen
            )
        }
    }
}