package hu.paulolajos.bookmanager.navigation

import hu.paulolajos.bookmanager.core.Constants.Companion.BOOKS_SCREEN
import hu.paulolajos.bookmanager.core.Constants.Companion.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    object BooksScreen: Screen(BOOKS_SCREEN)
    object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)
}