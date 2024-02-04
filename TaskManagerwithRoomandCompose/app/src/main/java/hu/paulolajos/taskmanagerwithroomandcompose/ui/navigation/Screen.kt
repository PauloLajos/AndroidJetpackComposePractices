package hu.paulolajos.taskmanagerwithroomandcompose.ui.navigation

import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.TASKS_SCREEN
import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.UPDATE_TASK_SCREEN

sealed class Screen(val route: String) {
    object TasksScreen: Screen(TASKS_SCREEN)
    object UpdateTaskScreen: Screen(UPDATE_TASK_SCREEN)
}