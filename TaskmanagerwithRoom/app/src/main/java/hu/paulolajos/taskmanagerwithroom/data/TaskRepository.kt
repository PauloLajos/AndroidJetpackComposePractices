package hu.paulolajos.taskmanagerwithroom.data

import hu.paulolajos.taskmanagerwithroom.data.model.TaskItem
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTaskItems(): Flow<List<TaskItem>>

    fun getTaskItem(id: Int): Flow<TaskItem?>

    suspend fun insertTaskItem(taskItem: TaskItem)

    suspend fun deleteTaskItem(taskItem: TaskItem)

    suspend fun updateTaskItem(taskItem: TaskItem)
}