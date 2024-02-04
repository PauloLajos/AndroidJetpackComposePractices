package hu.paulolajos.bookmanager.presentation.books.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import hu.paulolajos.bookmanager.core.Constants.Companion.BOOKS_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksTopBar() {
    TopAppBar (
        title = {
            Text(
                text = BOOKS_SCREEN
            )
        }
    )
}
