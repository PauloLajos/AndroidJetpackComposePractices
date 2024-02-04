package hu.paulolajos.bookmanager.presentation.books.components

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
import hu.paulolajos.bookmanager.R
import hu.paulolajos.bookmanager.core.Constants.Companion.EMPTY_STRING
import hu.paulolajos.bookmanager.domain.model.Book
import kotlinx.coroutines.job

@Composable
fun AddBookAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addBook: (book: Book) -> Unit
) {
    if (openDialog) {
        var title by remember { mutableStateOf(EMPTY_STRING) }
        var author by remember { mutableStateOf(EMPTY_STRING) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = stringResource(id = R.string.add_book)
                )
            },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.book_title)
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
                        value = author,
                        onValueChange = { author = it },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.author)
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val book = Book(0, title, author)
                        addBook(book)
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