package hu.paulolajos.taskmanagerwithroomandcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.TASK_ID
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task.ListTaskScreen
import hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.update_task.UpdateTaskScreen
import hu.paulolajos.taskmanagerwithroomandcompose.ui.navigation.Screen.TasksScreen
import hu.paulolajos.taskmanagerwithroomandcompose.ui.navigation.Screen.UpdateTaskScreen

@Composable
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = TasksScreen.route
    ) {
        composable(
            route = TasksScreen.route
        ) {
            ListTaskScreen(
                navigateToUpdateTaskScreen = { taskId ->
                    navController.navigate(
                        route = "${UpdateTaskScreen.route}/${taskId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdateTaskScreen.route}/{$TASK_ID}",
            arguments = listOf(
                navArgument(TASK_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt(TASK_ID) ?: 0
            UpdateTaskScreen(
                taskId = taskId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}