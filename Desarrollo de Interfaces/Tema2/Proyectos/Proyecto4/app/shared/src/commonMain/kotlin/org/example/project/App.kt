package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.viewModels.BibliotecaVM
import org.example.project.views.Buscador


@Composable
fun App() {
    MaterialTheme {
        val viewModel: BibliotecaVM = viewModel { BibliotecaVM() }
        Buscador(viewModel = viewModel)
    }
}