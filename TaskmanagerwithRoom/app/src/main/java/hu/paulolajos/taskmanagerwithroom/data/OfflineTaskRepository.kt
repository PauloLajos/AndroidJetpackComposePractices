package hu.paulolajos.taskmanagerwithroom.data

import hu.paulolajos.taskmanagerwithroom.data.model.TaskItem
import kotlinx.coroutines.flow.Flow

class OfflineTaskRepository(private val itemDao: TaskDao) : TaskRepository {
    override fun getAllTaskItems(): Flow<List<TaskItem>> = itemDao.getAllTaskItems()


    override fun getTaskItem(id: Int): Flow<TaskItem?> = itemDao.getTaskItem(id)

    override suspend fun insertTaskItem(taskItem: TaskItem) = itemDao.insert(taskItem)

    override suspend fun deleteTaskItem(taskItem: TaskItem) = itemDao.delete((taskItem))

    override suspend fun updateTaskItem(taskItem: TaskItem) = itemDao.update((taskItem))

}