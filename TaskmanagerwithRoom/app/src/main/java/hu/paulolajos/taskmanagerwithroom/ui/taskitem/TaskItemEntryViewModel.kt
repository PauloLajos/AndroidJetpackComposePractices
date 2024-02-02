package hu.paulolajos.taskmanagerwithroom.ui.taskitem

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import hu.paulolajos.taskmanagerwithroom.data.TaskRepository
import hu.paulolajos.taskmanagerwithroom.data.model.TaskItem
import hu.paulolajos.taskmanagerwithroom.data.model.TaskPriority

class TaskItemEntryViewModel(private val taskRepository: TaskRepository) : ViewModel() {
    var taskItemUiState by mutableStateOf(TaskItemUiState())
        private set

    fun updateUiState(itemDetails: TaskItemDetails) {
        taskItemUiState =
            TaskItemUiState(taskItemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    private fun validateInput(uiState: TaskItemDetails = taskItemUiState.taskItemDetails): Boolean {
        return with(uiState) {
            description.isNotBlank()
        }
    }

    suspend fun saveItem() {
        if (validateInput()) {
            taskRepository.insertTaskItem(taskItemUiState.taskItemDetails.toItem())
        }
    }
}

data class TaskItemUiState(
    val taskItemDetails: TaskItemDetails = TaskItemDetails(),
    val isEntryValid: Boolean = false
)

data class TaskItemDetails(
    val id: Long = 0L,
    val description: String = "",
    val isReminderSet: Boolean = true,
    val isOpen: Boolean = true,
    val createdOn: String = "",
    val priority: TaskPriority = TaskPriority.LOW
)

fun TaskItemDetails.toItem(): TaskItem = TaskItem(
    id = id,
    description = description,
    isReminderSet = isReminderSet,
    isOpen = isOpen,
    createdOn = createdOn,
    priority = TaskPriority.MEDIUM
)