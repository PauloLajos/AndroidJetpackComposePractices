package hu.paulolajos.taskmanagerwithroom.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.paulolajos.taskmanagerwithroom.data.TaskRepository
import hu.paulolajos.taskmanagerwithroom.data.model.TaskItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(taskRepository: TaskRepository) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        taskRepository.getAllTaskItems().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class HomeUiState(val taskList: List<TaskItem> = listOf())