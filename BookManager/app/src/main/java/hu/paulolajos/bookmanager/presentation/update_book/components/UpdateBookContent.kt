package hu.paulolajos.bookmanager.presentation.update_book.components

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
import androidx.compose.ui.unit.dp
import hu.paulolajos.bookmanager.core.Constants.Companion.AUTHOR
import hu.paulolajos.bookmanager.core.Constants.Companion.BOOK_TITLE
import hu.paulolajos.bookmanager.core.Constants.Companion.UPDATE_BUTTON
import hu.paulolajos.bookmanager.domain.model.Book

@Composable
fun UpdateBookContent(
    padding: PaddingValues,
    book: Book,
    updateTitle: (title: String) -> Unit,
    updateAuthor: (author: String) -> Unit,
    updateBook: (book: Book) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = book.title,
            onValueChange = { title ->
                updateTitle(title)
            },
            placeholder = {
                Text(
                    text = BOOK_TITLE
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = book.author,
            onValueChange = { author ->
                updateAuthor(author)
            },
            placeholder = {
                Text(
                    text = AUTHOR
                )
            }
        )
        Button(
            onClick = {
                updateBook(book)
                navigateBack()
            }
        ) {
            Text(
                text = UPDATE_BUTTON
            )
        }
    }
}