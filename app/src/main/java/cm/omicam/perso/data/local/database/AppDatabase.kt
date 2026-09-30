package cm.omicam.perso.data.local.database

import androidx.room3.Database
import androidx.room3.RoomDatabase
import cm.omicam.perso.data.local.dao.PersonDao
import cm.omicam.perso.data.local.entity.Person

@Database(
    entities = [Person::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}
