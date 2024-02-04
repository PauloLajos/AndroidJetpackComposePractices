package hu.paulolajos.taskmanagerwithroomandcompose.data.repository

import hu.paulolajos.taskmanagerwithroomandcompose.data.dao.TaskDao
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task
import hu.paulolajos.taskmanagerwithroomandcompose.domain.repository.TaskRepository

class TaskRepositoryImpl(
    private val taskDao: TaskDao
) : TaskRepository {
    override fun getTasksFromRoom() = taskDao.getTasks()

    override suspend fun getTaskFromRoom(id: Int) = taskDao.getTask(id)

    override suspend fun addTaskToRoom(task: Task) = taskDao.addTask(task)

    override suspend fun updateTaskInRoom(task: Task) = taskDao.updateTask(task)

    override suspend fun deleteTaskFromRoom(task: Task) = taskDao.deleteTask(task)
}