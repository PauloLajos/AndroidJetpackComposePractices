package hu.paulolajos.bookmanager.domain.repository

import hu.paulolajos.bookmanager.domain.model.Book
import kotlinx.coroutines.flow.Flow

typealias Books = List<Book>

interface BookRepository {
    fun getBooksFromRoom(): Flow<Books>

    suspend fun getBookFromRoom(id: Int): Book

    suspend fun addBookToRoom(book: Book)

    suspend fun updateBookInRoom(book: Book)

    suspend fun deleteBookFromRoom(book: Book)
}