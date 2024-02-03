package hu.paulolajos.taskmanagement.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.paulolajos.taskmanagement.data.Task
import hu.paulolajos.taskmanagement.data.TaskRepository
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    private val _tasks = mutableStateOf<List<Task>>(emptyList())
    val tasks: State<List<Task>> = _tasks

    private var _onLoading by mutableStateOf(false)
    val onLoading: Boolean
        get() = _onLoading

    init {
        loadTask()
    }

    private fun loadTask() {
        viewModelScope.launch() {
            _tasks.value = repository.getAllTask()
        }
    }


    suspend fun insertTask(task: Task) {
        viewModelScope.launch {
            _onLoading = true
            repository.insertTask(task)
            _tasks.value = repository.getAllTask()
            _onLoading = false
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
            _tasks.value = repository.getAllTask()
        }
    }
}