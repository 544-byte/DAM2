package org.example.project.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import org.example.project.models.BasicModel
import org.example.project.viewModels.BaseViewModel

@Composable
fun BaseScreen(viewModel: BaseViewModel) {
    val (items, selectedItem) = viewModel.uiState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Desarrollo de Interfaces - MVVM",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        selectedItem?.let { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Seleccionado: ${item.title}", style = MaterialTheme.typography.titleMedium)
                    Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { viewModel.clearSelection() }) {
                        Text("Deseleccionar")
                    }
                }
            }
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items) { item ->
                ItemRow(item = item, onClick = { viewModel.selectItem(item) })
            }
        }
    }
}

@Composable
fun ItemRow(item: BasicModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = item.title, style = MaterialTheme.typography.titleSmall)
            Text(text = item.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}