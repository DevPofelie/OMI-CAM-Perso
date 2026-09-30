package cm.omicam.perso.data.local.database

import android.content.Context
import androidx.room3.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import cm.omicam.perso.data.local.entity.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader

object DatabaseProvider {
    @Volatile
    private var instance: AppDatabase? = null

    fun get(context: Context): AppDatabase =
        instance ?: synchronized(lock = this) {
            instance ?: Room.databaseBuilder<AppDatabase>(
                context.applicationContext,
                name = "omicam_persons.db"
            )
                .setDriver(BundledSQLiteDriver())
                .setQueryCoroutineContext(Dispatchers.IO)
                .build()
                .also { db ->
                    instance = db
                    seedIfEmpty(context.applicationContext, db)
                }
        }

    private fun seedIfEmpty(context: Context, db: AppDatabase) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val dao = db.personDao()
                if (dao.count() == 0) {
                    val persons = parseCsvFromAssets(context)
                    dao.insertAll(persons)
                }
            } catch (e: Exception) {
                android.util.Log.e("DatabaseProvider", "Erreur seed CSV", e)
            }
        }
    }

    private fun parseCsvFromAssets(context: Context): List<Person> {
        val persons = mutableListOf<Person>()
        context.assets.open("indexalphaomicam_seed.csv").use { input ->
            BufferedReader(InputStreamReader(input, Charsets.UTF_8)).useLines { lines ->
                lines.drop(1).forEach { line ->
                    if (line.isBlank()) return@forEach
                    val cols = line.split(",")
                    if (cols.size < 11) return@forEach
                    persons.add(
                        Person(
                            nomComplet = cols[0],
                            naissance = cols[1].ifBlank { null },
                            nationalite = cols[2].ifBlank { null },
                            fete = cols[3].ifBlank { null },
                            premiersVoeux = cols[4].ifBlank { null },
                            voeuxPerpetuels = cols[5].ifBlank { null },
                            sacerdoce = cols[6].ifBlank { null },
                            numeroOblation = cols[7].ifBlank { null },
                            unite = cols[8].ifBlank { null },
                            email = cols[9].ifBlank { null },
                            telephone = cols[10].ifBlank { null }
                        )
                    )
                }
            }
        }
        return persons
    }
}
