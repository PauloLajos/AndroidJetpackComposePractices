package hu.paulolajos.motorcyclesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.MotorcycleScreen
import hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.MotorcyclesEvent
import hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen.MotorcyclesScreenViewModel
import hu.paulolajos.motorcyclesapp.presentation.registrationscreen.RegistrationScreen

@Composable
fun MotorcyclesNavHost(
    motorcyclesScreenViewModel: MotorcyclesScreenViewModel,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MotorcycleList.route
    ) {
        composable(Screen.MotorcycleList.route) {
            MotorcycleScreen(
                state = motorcyclesScreenViewModel.state.value,
                onItemClick = { id ->
                    navController.navigate("${Screen.AddEditMotorcycle.route}/$id")
                },
                fabOnClick = { navController.navigate("${Screen.AddEditMotorcycle.route}/0") },
                onFilterButtonClick = { motorcyclesScreenViewModel.onEvent(MotorcyclesEvent.Order(it)) },
                onButtonToggleOrderSelection = { motorcyclesScreenViewModel.onEvent(MotorcyclesEvent.ToogleOrderSection) },
                onDeleteButtonClick = { motorcyclesScreenViewModel.deleteAllMotorcycle() }
            )
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