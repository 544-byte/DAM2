package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.data.repository.ArtRepositoryImplement
import org.example.project.domain.usecase.GetArtListItems
import org.example.project.presentation.viewModel.ArtViewModel
import org.example.project.presentation.view.ArtV

@Composable
fun App() {
    MaterialTheme {
        val viewModel: ArtViewModel = viewModel {
            ArtViewModel(GetArtListItems(ArtRepositoryImplement()))
        }
        ArtV(viewModel = viewModel)
    }
}