package hu.paulolajos.taskmanagerwithroom.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskItem: TaskItem)

    @Update
    suspend fun update(taskItem: TaskItem)

    @Delete
    suspend fun delete(taskItem: TaskItem)

    @Query("SELECT * from taskItems WHERE id = :id")
    fun getTaskItem(id: Int): Flow<TaskItem>

    @Query("SELECT * from taskItems ORDER BY createdOn DESC")
    fun getAllTaskItems(): Flow<List<TaskItem>>

}