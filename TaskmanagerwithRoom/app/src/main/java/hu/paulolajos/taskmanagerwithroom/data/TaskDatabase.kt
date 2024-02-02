package hu.paulolajos.taskmanagerwithroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.paulolajos.taskmanagerwithroom.data.model.TaskItem

@Database(entities = [TaskItem::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun itemDao(): TaskDAO

    companion object {
        @Volatile
        private var Instance: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TaskDatabase::class.java, "task_database")
                    // Since this is a sample app, a simple alternative is to destroy
                    // and rebuild the database, which means that the inventory data is lost:
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}