package cm.omicam.perso.data.local.entity

import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.Index
import androidx.room3.PrimaryKey

@Entity(
    tableName = "indexalphaomicam",
    indices = [
        Index(value = ["nom_complet"]),
        Index(value = ["nationalite"]),
        Index(value = ["unite"])
    ]
)
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "nom_complet")
    val nomComplet: String,
    val naissance: String? = null,
    val nationalite: String? = null,
    val fete: String? = null,
    @ColumnInfo(name = "premiers_voeux")
    val premiersVoeux: String? = null,
    @ColumnInfo(name = "voeux_perpetuels")
    val voeuxPerpetuels: String? = null,
    val sacerdoce: String? = null,
    @ColumnInfo(name = "numero_oblation")
    val numeroOblation: String? = null,
    val unite: String? = null,
    val email: String? = null,
    val telephone: String? = null
)
