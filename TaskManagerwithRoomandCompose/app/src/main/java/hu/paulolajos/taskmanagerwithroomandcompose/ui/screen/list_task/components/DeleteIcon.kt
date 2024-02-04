package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import hu.paulolajos.taskmanagerwithroomandcompose.R

@Composable
fun DeleteIcon(
    deleteTask: () -> Unit,
    title: String,
    description: String
) {
    var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }

    IconButton(
        onClick = { deleteConfirmationRequired = true },
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = stringResource(id = R.string.delete_task),
        )
        if (deleteConfirmationRequired) {
            DeleteConfirmationDialog(
                title = title,
                description = description,
                onDeleteConfirm = {
                    deleteConfirmationRequired = false
                    deleteTask()
                },
                onDeleteCancel = { deleteConfirmationRequired = false },
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}