package hu.paulolajos.taskmanagerwithroomandcompose.domain.repository

import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task
import kotlinx.coroutines.flow.Flow

typealias Tasks = List<Task>

interface TaskRepository {
    fun getTasksFromRoom(): Flow<Tasks>

    suspend fun getTaskFromRoom(id: Int): Task

    suspend fun addTaskToRoom(task: Task)

    suspend fun updateTaskInRoom(task: Task)

    suspend fun deleteTaskFromRoom(task: Task)
}