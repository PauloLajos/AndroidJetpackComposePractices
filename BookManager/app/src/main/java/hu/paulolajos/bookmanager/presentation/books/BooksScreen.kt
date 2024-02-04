package hu.paulolajos.bookmanager.presentation.books

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import hu.paulolajos.bookmanager.domain.model.Book
import hu.paulolajos.bookmanager.presentation.books.components.AddBookAlertDialog
import hu.paulolajos.bookmanager.presentation.books.components.AddBookFloatingActionButton
import hu.paulolajos.bookmanager.presentation.books.components.BooksContent
import hu.paulolajos.bookmanager.presentation.books.components.BooksTopBar

@Composable
fun BooksScreen(
    viewModel: BooksViewModel = hiltViewModel(),
    navigateToUpdateBookScreen: (bookId: Int) -> Unit
) {
    val books by viewModel.books.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            BooksTopBar()
        },
        content = { padding ->
            BooksContent(
                padding = padding,
                books = books,
                deleteBook = { book ->
                    viewModel.deleteBook(book)
                },
                navigateToUpdateBookScreen = navigateToUpdateBookScreen
            )
            AddBookAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addBook = { book ->
                    viewModel.addBook(book)
                }
            )
        },
        floatingActionButton = {
            AddBookFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}

@Preview
@Composable
fun BooksContentPreview() {
    BooksContent(
        padding = PaddingValues(8.dp),
        books = listOf(
            Book(0,"Tom Sawyer","Mark Twain"),
            Book(1,"Huckleberry Finn","Mark Twain"),
            Book(2,"Egri csillagok","Gárdonyi Géza")
        ),
        deleteBook = {},
        navigateToUpdateBookScreen = {}
    )
}