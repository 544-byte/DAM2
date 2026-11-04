package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.data.repository.ParcelaRepositoryImplement
import org.example.project.domain.usecase.GetParcelaListItems
import org.example.project.viewModels.*
import org.example.project.views.*


@Composable
fun App() {
    MaterialTheme {
        val viewModel: ParcelaViewModel = viewModel { ParcelaViewModel(getParcelaListItems = GetParcelaListItems(
            ParcelaRepositoryImplement())) }
        ParcelaV(viewModel = viewModel)
    }
}