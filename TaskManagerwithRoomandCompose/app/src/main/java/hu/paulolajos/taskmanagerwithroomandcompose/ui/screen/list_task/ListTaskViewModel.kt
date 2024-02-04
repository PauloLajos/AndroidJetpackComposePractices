package hu.paulolajos.taskmanagerwithroomandcompose.ui.screen.list_task

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.EMPTY_STRING
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task
import hu.paulolajos.taskmanagerwithroomandcompose.domain.repository.TaskRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListTaskViewModel @Inject constructor(
    private val repo: TaskRepository
) : ViewModel() {
    var task by mutableStateOf(Task(0, EMPTY_STRING, EMPTY_STRING))
        private set
    var openDialog by mutableStateOf(false)

    val tasks = repo.getTasksFromRoom()

    fun getTask(id: Int) = viewModelScope.launch {
        task = repo.getTaskFromRoom(id)
    }

    fun addTask(task: Task) = viewModelScope.launch {
        repo.addTaskToRoom(task)
    }

    fun updateTask(task: Task) = viewModelScope.launch {
        repo.updateTaskInRoom(task)
    }

    fun deleteTask(task: Task) = viewModelScope.launch {
        repo.deleteTaskFromRoom(task)
    }

    fun updateTitle(title: String) {
        task = task.copy(
            title = title
        )
    }

    fun updateDescription(description: String) {
        task = task.copy(
            description = description
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}