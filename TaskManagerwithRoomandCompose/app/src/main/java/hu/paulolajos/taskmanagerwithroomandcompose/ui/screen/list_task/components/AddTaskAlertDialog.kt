package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.paulolajos.taskmanagerwithroomandcompose.R
import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.EMPTY_STRING
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task
import kotlinx.coroutines.job

@Composable
fun AddTaskAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addTask: (task: Task) -> Unit
) {
    if (openDialog) {
        var title by remember { mutableStateOf(EMPTY_STRING) }
        var description by remember { mutableStateOf(EMPTY_STRING) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = stringResource(id = R.string.add_task)
                )
            },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.task_title)
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.task_description)
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val task = Task(0, title, description)
                        addTask(task)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.add_button)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = stringResource(id = R.string.dismiss_button)
                    )
                }
            }
        )
    }
}