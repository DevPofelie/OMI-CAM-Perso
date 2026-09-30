package cm.omicam.perso.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val route: String, val label: String, val icon: ImageVector) {
    object Accueil : Destination("home", "Accueil", Icons.Default.Home)
    object Fullness : Destination("fullness", "Fullness", Icons.Default.People)
    object OmiCameroun : Destination("omicameroun", "OMICameroun", Icons.Default.Church)
    object SaintSiege : Destination("saint_siege", "Saint Siège", Icons.Default.Public)
    object OmiWorld : Destination("omiworld", "OMIWorld", Icons.Default.Language)
    object Sceam : Destination("sceam", "SCEAM", Icons.Default.Groups)
    object Acerac : Destination("acerac", "ACERAC", Icons.Default.Groups)
    object ComitesProvinciaux : Destination("comites", "Comités Provinciaux", Icons.Default.Groups)
    object Districts : Destination("districts", "Districts", Icons.Default.Map)
    object Cenc : Destination("cenc", "CENC", Icons.Default.Groups)
    object Dioceses : Destination("dioceses", "Diocèses", Icons.Default.AccountBalance)
    object Formation : Destination("formation", "Formation", Icons.Default.School)
    object OmiCamNetwork : Destination("omicamnetwork", "OMICamNetWork", Icons.Default.Hub)
}

val bottomBarItems = listOf(
    Destination.Accueil, Destination.Fullness,
    Destination.OmiCameroun, Destination.SaintSiege
)

val drawerItems = listOf(
    Destination.OmiWorld, Destination.Sceam, Destination.Acerac,
    Destination.ComitesProvinciaux, Destination.Districts, Destination.Cenc,
    Destination.Dioceses, Destination.Formation, Destination.OmiCamNetwork
)