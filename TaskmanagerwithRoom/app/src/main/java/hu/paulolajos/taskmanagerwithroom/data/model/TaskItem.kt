package hu.paulolajos.taskmanagerwithroom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "taskItems")
data class TaskItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val description: String,
    val isReminderSet: Boolean,
    val isOpen: Boolean,
    val createdOn: String,
    val priority: TaskPriority
)