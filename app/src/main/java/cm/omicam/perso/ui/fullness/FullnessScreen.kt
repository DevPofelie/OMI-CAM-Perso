package cm.omicam.perso.ui.fullness

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cm.omicam.perso.data.local.entity.Person
import cm.omicam.perso.viewmodel.PersonViewModel

@Composable
fun FullnessScreen(
    viewModel: PersonViewModel,
    onPersonClick: (Long) -> Unit = {}
) {
    val query by viewModel.searchQuery.collectAsState()
    val persons by viewModel.persons.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Fullness", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = query,
            onValueChange = viewModel::setSearchQuery,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Rechercher")
            },
            label = { Text("Personne, nationalité ou unité") }
        )

        Text("${persons.size} résultat(s)")

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(persons, key = { it.id }) { person ->
                PersonCard(person) { onPersonClick(person.id) }
            }
        }
    }
}

@Composable
private fun PersonCard(person: Person, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(person.nomComplet, style = MaterialTheme.typography.titleMedium)
            Text(person.nationalite.orEmpty())
            Text(person.unite.orEmpty())
            person.numeroOblation?.takeIf { it.isNotBlank() }?.let {
                Text("Oblation : $it", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
