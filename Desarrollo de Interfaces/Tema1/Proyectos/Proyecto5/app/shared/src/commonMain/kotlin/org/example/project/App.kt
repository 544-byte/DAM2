package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.viewModels.RecetarioVM
import org.example.project.views.RecetarioV


@Composable
fun App() {
    MaterialTheme {
        val viewModel: RecetarioVM = viewModel { RecetarioVM() }
        RecetarioV(viewModel = viewModel)
    }
}