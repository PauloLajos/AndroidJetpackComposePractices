package hu.paulolajos.taskmanagerwithroomandcompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.TASK_TABLE
import hu.paulolajos.taskmanagerwithroomandcompose.domain.model.Task
import hu.paulolajos.taskmanagerwithroomandcompose.domain.repository.Tasks
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM $TASK_TABLE ORDER BY id ASC")
    fun getTasks(): Flow<Tasks>

    @Query("SELECT * FROM $TASK_TABLE WHERE id = :id")
    suspend fun getTask(id: Int): Task

    @Insert(onConflict = IGNORE)
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}