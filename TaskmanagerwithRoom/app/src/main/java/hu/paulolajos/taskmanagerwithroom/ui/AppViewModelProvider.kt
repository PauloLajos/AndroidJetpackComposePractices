package hu.paulolajos.taskmanagerwithroom.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import hu.paulolajos.taskmanagerwithroom.app.TaskManagerApp
import hu.paulolajos.taskmanagerwithroom.ui.home.HomeViewModel
import hu.paulolajos.taskmanagerwithroom.ui.taskitem.TaskItemEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(taskApplication().container.taskRepository)
        }

        // Initializer for ItemEntryViewModel
        initializer {
            TaskItemEntryViewModel(taskApplication().container.taskRepository)
        }
/*
        initializer {
            TaskItemEditViewModel(
                this.createSavedStateHandle(),
                taskApplication().container.taskRepository
            )
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            TaskItemDetailsViewModel(
                this.createSavedStateHandle(),
                taskApplication().container.taskRepository
            )
        }
*/
    }
}

fun CreationExtras.taskApplication(): TaskManagerApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TaskManagerApp)
