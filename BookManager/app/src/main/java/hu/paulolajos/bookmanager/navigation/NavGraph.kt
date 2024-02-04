package hu.paulolajos.bookmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import hu.paulolajos.bookmanager.core.Constants.Companion.BOOK_ID
import hu.paulolajos.bookmanager.presentation.books.BooksScreen
import hu.paulolajos.bookmanager.presentation.update_book.UpdateBookScreen

@Composable
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.BooksScreen.route
    ) {
        composable(
            route = Screen.BooksScreen.route
        ) {
            BooksScreen(
                navigateToUpdateBookScreen = { bookId ->
                    navController.navigate(
                        route = "${Screen.UpdateBookScreen.route}/${bookId}"
                    )
                }
            )
        }
        composable(
            route = "${Screen.UpdateBookScreen.route}/{$BOOK_ID}",
            arguments = listOf(
                navArgument(BOOK_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt(BOOK_ID) ?: 0
            UpdateBookScreen(
                bookId = bookId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}