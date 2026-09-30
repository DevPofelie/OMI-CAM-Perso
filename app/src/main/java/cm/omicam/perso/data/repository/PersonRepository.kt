package cm.omicam.perso.data.repository

import cm.omicam.perso.data.local.dao.PersonDao
import cm.omicam.perso.data.local.entity.Person
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val dao: PersonDao) {
    fun observeAll(): Flow<List<Person>> = dao.observeAll()
    fun search(query: String): Flow<List<Person>> =
        if (query.isBlank()) dao.observeAll() else dao.search(query.trim())
    fun observeCount(): Flow<Int> = dao.observeCount()
    suspend fun findById(id: Long): Person? = dao.findById(id)
    suspend fun insertAll(persons: List<Person>) = dao.insertAll(persons)
}
