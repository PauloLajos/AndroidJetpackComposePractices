package hu.paulolajos.taskmanagerwithroomandcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.paulolajos.taskmanagerwithroomandcompose.core.Constants.Companion.TASK_TABLE
import hu.paulolajos.taskmanagerwithroomandcompose.data.dao.TaskDao
import hu.paulolajos.taskmanagerwithroomandcompose.data.network.TaskDb
import hu.paulolajos.taskmanagerwithroomandcompose.data.repository.TaskRepositoryImpl
import hu.paulolajos.taskmanagerwithroomandcompose.domain.repository.TaskRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideTaskDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        TaskDb::class.java,
        TASK_TABLE
    ).build()

    @Provides
    fun provideTaskDao(
        taskDb: TaskDb
    ) = taskDb.taskDao

    @Provides
    fun provideTaskRepository(
        taskDao: TaskDao
    ): TaskRepository = TaskRepositoryImpl(
        taskDao = taskDao
    )
}