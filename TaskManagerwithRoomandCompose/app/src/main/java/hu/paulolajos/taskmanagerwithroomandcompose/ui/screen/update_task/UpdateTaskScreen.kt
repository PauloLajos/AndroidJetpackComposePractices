package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.update_task

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UpdateTaskScreen(
    //viewModel: TasksViewModel = hiltViewModel(),
    taskId: Int,
    navigateBack: () -> Unit
) {
    Text(text = "UpdateTaskScreen")
}