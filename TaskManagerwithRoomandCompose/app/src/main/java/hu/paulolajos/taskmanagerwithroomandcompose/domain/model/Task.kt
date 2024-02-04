package hu.paulolajos.taskmanagerwithroomandcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.TASK_TABLE

@Entity(tableName = TASK_TABLE)
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String
)