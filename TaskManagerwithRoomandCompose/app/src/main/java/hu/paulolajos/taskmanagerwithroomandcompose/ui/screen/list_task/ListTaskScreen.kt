package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
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

@SuppressLint("UnrememberedMutableState")
@Composable
fun ListTaskScreen(
    viewModel: ListTaskViewModel = hiltViewModel(),
    navigateToUpdateTaskScreen: (bookId: Int) -> Unit
) {
    val tasks by viewModel.tasks.collectAsState(
        initial = emptyList()
    )
    val coroutineScope = rememberCoroutineScope()

    val listState = rememberLazyListState()
    val fabVisibility by derivedStateOf {
        listState.firstVisibleItemIndex == 0
    }

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
                navigateToUpdateTaskScreen = navigateToUpdateTaskScreen,
                listState = listState
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
                },
                isVisibleBecauseOfScrolling = fabVisibility
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
        navigateToUpdateTaskScreen = {},
        listState = LazyListState()
    )
}