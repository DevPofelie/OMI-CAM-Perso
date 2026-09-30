package cm.omicam.perso.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cm.omicam.perso.ui.fullness.FullnessScreen
import cm.omicam.perso.ui.screens.HomeScreen
import cm.omicam.perso.ui.screens.ConstructionScreen
import cm.omicam.perso.viewmodel.PersonViewModel
import cm.omicam.perso.ui.screens.OmicamScreen
import cm.omicam.perso.ui.screens.OmiworldScreen

object Routes {
    const val HOME = "home"
    const val FULLNESS = "fullness"
}

@Composable
fun AppNavigation(navController: NavHostController, viewModel: PersonViewModel) {
    NavHost(navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(viewModel) {
                navController.navigate(Routes.FULLNESS)
            }
        }
        composable(Routes.FULLNESS) {
            FullnessScreen(viewModel)
        }
        composable(Destination.SaintSiege.route) { ConstructionScreen(title = "Saint Siège") }
        composable(Destination.OmiWorld.route) { OmiworldScreen(title = "OMIWorld") }
        composable(Destination.Sceam.route) { ConstructionScreen(title = "SCEAM") }
        composable(Destination.OmiCameroun.route) { ConstructionScreen(title = "OMICameroun") }
        composable(Destination.Acerac.route) { ConstructionScreen(title = "ACERAC") }
        composable(Destination.ComitesProvinciaux.route) { ConstructionScreen(title = "Comités Provinciaux") }
        composable(Destination.Districts.route) { ConstructionScreen(title = "Districts") }
        composable(Destination.Cenc.route) { ConstructionScreen(title = "CENC") }
        composable(Destination.Dioceses.route) { ConstructionScreen(title = "Diocèses") }
        composable(Destination.Formation.route) { ConstructionScreen(title = "Formation") }
        composable(Destination.OmiCamNetwork.route) { OmicamScreen(title = "OMICamNetWork") }
    }
}