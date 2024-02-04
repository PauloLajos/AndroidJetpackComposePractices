package hu.paulolajos.bookmanager.presentation.books.components

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
import hu.paulolajos.bookmanager.R
import hu.paulolajos.bookmanager.core.Constants.Companion.DELETE_BOOK

@Composable
fun DeleteIcon(
    deleteBook: () -> Unit,
    title: String,
    author: String
) {
    var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }

    IconButton(
        onClick = { deleteConfirmationRequired = true },
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_BOOK,
        )
        if (deleteConfirmationRequired) {
            DeleteConfirmationDialog(
                title = title,
                author = author,
                onDeleteConfirm = {
                    deleteConfirmationRequired = false
                    deleteBook()
                },
                onDeleteCancel = { deleteConfirmationRequired = false },
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}