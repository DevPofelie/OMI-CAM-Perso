package cm.omicam.perso.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cm.omicam.perso.viewmodel.PersonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: PersonViewModel,
    onNavigateToFullness: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("OMI-CAM Perso") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Province OMI du Cameroun",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Notre mission", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "Depuis 1816, les Missionnaires Oblats de Marie Immaculée se " +
                                "consacrent à l'évangélisation des plus pauvres et des plus délaissés, " +
                                "fidèles à l'appel de leur fondateur, Saint Eugène de Mazenod.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Notre Province", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "Présente au Cameroun, au Nigéria et au Tchad, la Province OMI " +
                                "du Cameroun rassemble des missionnaires engagés dans l'éducation, " +
                                "la santé et le développement communautaire au service des populations locales.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Button(
                onClick = onNavigateToFullness,
                modifier = Modifier.fillMaxWidth().height(52.dp)
            ) {
                Text("Annuaire du personnel")
            }

            Text(
                text = "OMI-CAM Perso — application interne du personnel de la Province",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}