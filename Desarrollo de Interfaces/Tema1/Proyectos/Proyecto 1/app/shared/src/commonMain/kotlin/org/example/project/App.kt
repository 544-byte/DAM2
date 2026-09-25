package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.viewModels.ArtVM
import org.example.project.views.ArtV

@Composable
fun App() {
    MaterialTheme {
        val viewModel: ArtVM = viewModel { ArtVM() }
        ArtV(viewModel = viewModel)
    }
}