package hu.paulolajos.bookmanager.presentation.books

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BooksScreen(
    navigateToUpdateBookScreen: (bookId: Int) -> Unit
) {
    Text(text = "BookScreen")
}