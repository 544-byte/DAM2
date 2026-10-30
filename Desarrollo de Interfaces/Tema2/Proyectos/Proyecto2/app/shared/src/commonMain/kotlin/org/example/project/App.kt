package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.viewModels.*
import org.example.project.views.*


@Composable
fun App() {
    MaterialTheme {
        val viewModel: ParcelaVM = viewModel { ParcelaVM() }
        ParcelaV(viewModel = viewModel)
    }
}