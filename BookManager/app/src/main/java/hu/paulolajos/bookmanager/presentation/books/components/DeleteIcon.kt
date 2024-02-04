package hu.paulolajos.bookmanager.presentation.books.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import hu.paulolajos.bookmanager.core.Constants.Companion.DELETE_BOOK

@Composable
fun DeleteIcon(
    deleteBook: () -> Unit
) {
    IconButton(
        onClick = deleteBook
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_BOOK,
        )
    }
}