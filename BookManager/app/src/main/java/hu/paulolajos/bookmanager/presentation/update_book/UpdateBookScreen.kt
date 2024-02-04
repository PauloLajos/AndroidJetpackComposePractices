package hu.paulolajos.bookmanager.presentation.update_book

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import hu.paulolajos.bookmanager.domain.model.Book
import hu.paulolajos.bookmanager.presentation.books.BooksViewModel
import hu.paulolajos.bookmanager.presentation.books.components.BooksContent
import hu.paulolajos.bookmanager.presentation.update_book.components.UpdateBookContent
import hu.paulolajos.bookmanager.presentation.update_book.components.UpdateBookTopBar

@Composable
fun UpdateBookScreen(
    viewModel: BooksViewModel = hiltViewModel(),
    bookId: Int,
    navigateBack: () -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getBook(bookId)
    }
    Scaffold(
        topBar = {
            UpdateBookTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateBookContent(
                padding = padding,
                book = viewModel.book,
                updateTitle = { title ->
                    viewModel.updateTitle(title)
                },
                updateAuthor = { author ->
                    viewModel.updateAuthor(author)
                },
                updateBook = { book ->
                    viewModel.updateBook(book)
                },
                navigateBack = navigateBack
            )
        }
    )
}

@Preview
@Composable
fun UpdateBooksContentPreview() {
    UpdateBookContent(
        padding = PaddingValues(8.dp),
        book = Book(0,"Tom Sawyer","Mark Twain"),
        navigateBack = {},
        updateAuthor = {},
        updateBook = {},
        updateTitle = {}
    )
}