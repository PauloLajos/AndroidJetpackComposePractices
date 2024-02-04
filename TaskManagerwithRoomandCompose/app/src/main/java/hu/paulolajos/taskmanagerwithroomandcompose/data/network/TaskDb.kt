package hu.paulolajos.taskmanagerwithroomandcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.paulolajos.taskmanagerwithroomandcompose.data.dao.TaskDao
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
abstract class TaskDb : RoomDatabase() {
    abstract val taskDao: TaskDao
}