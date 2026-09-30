package cm.omicam.perso.data.local.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import cm.omicam.perso.data.local.entity.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Query("SELECT * FROM indexalphaomicam ORDER BY nom_complet COLLATE NOCASE ASC")
    fun observeAll(): Flow<List<Person>>

    @Query("SELECT * FROM indexalphaomicam WHERE nom_complet LIKE '%' || :query || '%' OR nationalite LIKE '%' || :query || '%' OR unite LIKE '%' || :query || '%'")
    fun search(query: String): Flow<List<Person>>

    @Query("SELECT COUNT(*) FROM indexalphaomicam")
    fun observeCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM indexalphaomicam")
    suspend fun count(): Int

    @Query("SELECT * FROM indexalphaomicam WHERE id = :id LIMIT 1")
    suspend fun findById(id: Long): Person?

    @Insert
    suspend fun insert(person: Person): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(persons: List<Person>)
}
