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
import org.example.project.viewModels.UserHealthVM

@Composable
fun UserHealthScreen(viewModel: UserHealthVM) {
    val (userHealth) = viewModel.uiState.collectAsState().value

    Column() {
        Text(text = userHealth?.altura.toString())
        Text(text = userHealth?.peso.toString())
        Text(text = userHealth?.nPasos.toString())
        Text(text = viewModel.objetivo().toString())
        Button(onClick = { viewModel.sumarPasos() }) {
            Text("sumar pasos")
        }
    }
}