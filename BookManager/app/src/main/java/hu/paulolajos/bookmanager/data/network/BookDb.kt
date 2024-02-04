package hu.paulolajos.bookmanager.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.paulolajos.bookmanager.data.dao.BookDao
import hu.paulolajos.bookmanager.domain.model.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDb : RoomDatabase() {
    abstract val bookDao: BookDao
}