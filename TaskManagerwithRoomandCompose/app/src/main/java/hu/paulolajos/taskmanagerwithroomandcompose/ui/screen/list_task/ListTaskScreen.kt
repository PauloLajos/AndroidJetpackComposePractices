package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ListTaskScreen(
    //viewModel: TasksViewModel = hiltViewModel(),
    navigateToUpdateTaskScreen: (bookId: Int) -> Unit
) {
    Text(text = "ListTaskScreen")
}