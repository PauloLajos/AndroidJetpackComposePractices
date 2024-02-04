package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.update_task.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.paulolajos.taskmanagerwithroomandcompose.R
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task

@Composable
fun UpdateTaskContent(
    padding: PaddingValues,
    task: Task,
    updateTitle: (title: String) -> Unit,
    updateDescription: (description: String) -> Unit,
    updateTask: (task: Task) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = task.title,
            onValueChange = { title ->
                updateTitle(title)
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.task_title)
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = task.description,
            onValueChange = { description ->
                updateDescription(description)
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.task_description)
                )
            }
        )
        Button(
            onClick = {
                updateTask(task)
                navigateBack()
            }
        ) {
            Text(
                text = stringResource(R.string.update_button)
            )
        }
    }
}