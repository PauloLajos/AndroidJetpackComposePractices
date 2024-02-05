package hu.paulolajos.motorcyclesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.MotorcycleScreen
import hu.paulolajos.motorcyclesapp.presentation.registrationscreen.RegistrationScreen

@Composable
fun MotorcyclesNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MotorcycleList.route
    ) {
        composable(Screen.MotorcycleList.route) {
            MotorcycleScreen()
        }
        composable(
            route = "${Screen.AddEditMotorcycle.route}/{motorcycle_id}",
            arguments = listOf(
                navArgument(
                    name = "motorcycle_id"
                ) {
                    type = NavType.IntType
                    defaultValue = 0
                })
        ) {
            RegistrationScreen()
        }
    }
}