package cm.omicam.perso.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import cm.omicam.perso.viewmodel.PersonViewModel
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(navController: NavHostController, viewModel: PersonViewModel) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
                drawerItems.forEach { dest ->
                    NavigationDrawerItem(
                        label = { Text(dest.label) },
                        icon = { Icon(dest.icon, contentDescription = null) },
                        selected = false,
                        onClick = {
                            navController.navigate(dest.route)
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomBarItems.forEach { dest ->
                        NavigationBarItem(
                            icon = { Icon(dest.icon, contentDescription = dest.label) },
                            label = { Text(dest.label) },
                            selected = false,
                            onClick = { navController.navigate(dest.route) }
                        )
                    }
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Menu, contentDescription = "Menu") },
                        label = { Text("Menu") },
                        selected = false,
                        onClick = { scope.launch { drawerState.open() } }
                    )
                }
            }
        ) { padding ->
            AppNavigation(
                navController = navController,
                viewModel = viewModel
            )
            // Note: le padding du Scaffold n'est pas appliqué ici —
            // AppNavigation.kt gère son propre contenu par écran.
            // Si un écran déborde sous la barre du bas, ajoute
            // Modifier.padding(padding) au conteneur racine de cet écran.
        }
    }
}