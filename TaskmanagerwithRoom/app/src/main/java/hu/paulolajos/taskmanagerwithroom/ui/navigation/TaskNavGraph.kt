package hu.paulolajos.taskmanagerwithroom.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import hu.paulolajos.taskmanagerwithroom.ui.home.HomeDestination
import hu.paulolajos.taskmanagerwithroom.ui.home.HomeScreen
import hu.paulolajos.taskmanagerwithroom.ui.taskitem.TaskItemDetailsDestination
import hu.paulolajos.taskmanagerwithroom.ui.taskitem.TaskItemDetailsScreen
import hu.paulolajos.taskmanagerwithroom.ui.taskitem.TaskItemEditDestination
import hu.paulolajos.taskmanagerwithroom.ui.taskitem.TaskItemEditScreen
import hu.paulolajos.taskmanagerwithroom.ui.taskitem.TaskItemEntryDestination
import hu.paulolajos.taskmanagerwithroom.ui.taskitem.TaskItemEntryScreen

@Composable
fun TaskNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToTaskItemEntry = { navController.navigate(TaskItemEntryDestination.route) },
                navigateToTaskItemUpdate = {
                    navController.navigate("${TaskItemDetailsDestination.route}/${it}")
                }
            )
        }
        composable(route = TaskItemEntryDestination.route) {
            TaskItemEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = TaskItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(TaskItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            TaskItemDetailsScreen(
                navigateToEditItem = { navController.navigate("${TaskItemEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = TaskItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(TaskItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            TaskItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
