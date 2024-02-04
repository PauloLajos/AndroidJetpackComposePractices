package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import hu.paulolajos.taskmanagerwithroomandcompose.R
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components.AddTaskAlertDialog
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components.AddTaskFloatingActionButton
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components.TasksContent
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components.TasksTopBar
import kotlinx.coroutines.launch

@Composable
fun ListTaskScreen(
    viewModel: ListTaskViewModel = hiltViewModel(),
    navigateToUpdateTaskScreen: (bookId: Int) -> Unit
) {
    val tasks by viewModel.tasks.collectAsState(
        initial = emptyList()
    )
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TasksTopBar()
        },
        content = { padding ->
            TasksContent(
                padding = padding,
                tasks = tasks,
                deleteTask = { task ->
                    coroutineScope.launch {
                        viewModel.deleteTask(task)
                    }
                },
                navigateToUpdateTaskScreen = navigateToUpdateTaskScreen
            )
            AddTaskAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addTask = { task ->
                    viewModel.addTask(task)
                }
            )
        },
        floatingActionButton = {
            AddTaskFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}

@Preview
@Composable
fun TasksContentPreview() {
    TasksContent(
        padding = PaddingValues(dimensionResource(R.dimen.padding_small)),
        tasks = listOf(
            Task(0,"Shop","shoes"),
            Task(1,"Office","Meeting"),
            Task(2,"Sport","Bowling")
        ),
        deleteTask = {},
        navigateToUpdateTaskScreen = {}
    )
}