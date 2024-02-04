package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.update_task

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import hu.paulolajos.taskmanagerwithroomandcompose.R
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.ListTaskViewModel
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.update_task.components.UpdateTaskContent
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.update_task.components.UpdateTaskTopBar

@Composable
fun UpdateTaskScreen(
    viewModel: ListTaskViewModel = hiltViewModel(),
    taskId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getTask(taskId)
    }
    Scaffold(
        topBar = {
            UpdateTaskTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateTaskContent(
                padding = padding,
                task = viewModel.task,
                updateTitle = { title ->
                    viewModel.updateTitle(title)
                },
                updateDescription = { description ->
                    viewModel.updateDescription(description)
                },
                updateTask = { task ->
                    viewModel.updateTask(task)
                },
                navigateBack = navigateBack
            )
        }
    )
}

@Preview
@Composable
fun UpdateTasksContentPreview() {
    UpdateTaskContent(
        padding = PaddingValues(dimensionResource(R.dimen.padding_small)),
        task = Task(0,"Sport","Bowling"),
        navigateBack = {},
        updateDescription = {},
        updateTask = {},
        updateTitle = {}
    )
}