package hu.paulolajos.bookmanager.presentation.update_book

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UpdateBookScreen(
    bookId: Int,
    navigateBack: () -> Unit
) {
    Text(text = "UpdateBookScreen")
}