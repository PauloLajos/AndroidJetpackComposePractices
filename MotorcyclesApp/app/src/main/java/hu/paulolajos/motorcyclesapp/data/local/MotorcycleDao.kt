package hu.paulolajos.motorcyclesapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MotorcycleDao {
    @Query("SELECT * FROM localmotorcycle")
    fun getAll(): Flow<List<LocalMotorcycle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(localMotorcycle: LocalMotorcycle)

    @Update(entity = LocalMotorcycle::class)
    suspend fun update(localMotorcycle: LocalMotorcycle)

    @Query("DELETE  FROM localmotorcycle WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE  FROM localmotorcycle")
    suspend fun deleteAll()

    @Query("SELECT * FROM localmotorcycle WHERE id = :id")
    suspend fun getMotorcycle(id: Int): LocalMotorcycle
}