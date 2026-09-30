package cm.omicam.perso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import cm.omicam.perso.data.local.database.DatabaseProvider
import cm.omicam.perso.data.repository.PersonRepository
import androidx.navigation.compose.rememberNavController
import cm.omicam.perso.ui.navigation.MainScaffold
import cm.omicam.perso.ui.theme.OmicamTheme
import cm.omicam.perso.viewmodel.PersonViewModel
import cm.omicam.perso.viewmodel.PersonViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = DatabaseProvider.get(applicationContext)
        val repository = PersonRepository(database.personDao())

        setContent {
            OmicamTheme {
                val personViewModel: PersonViewModel =
                    viewModel(factory = PersonViewModelFactory(repository))
                val navController = rememberNavController()
                MainScaffold(navController = navController, viewModel = personViewModel)
            }
        }
        }
    }
