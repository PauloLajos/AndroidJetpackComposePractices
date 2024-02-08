package hu.paulolajos.motorcyclesapp.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.paulolajos.motorcyclesapp.data.local.MotorcycleDao
import hu.paulolajos.motorcyclesapp.data.local.MotorcycleDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MotorcycleModule {

    @Provides
    fun providesRoomDao(database: MotorcycleDb): MotorcycleDao {
        return database.dao
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext
        appContext: Context
    ): MotorcycleDb {
        return Room.databaseBuilder(
            appContext,
            MotorcycleDb::class.java,
            "motorcycle_database"
        ).fallbackToDestructiveMigration()
            .build()
    }
}