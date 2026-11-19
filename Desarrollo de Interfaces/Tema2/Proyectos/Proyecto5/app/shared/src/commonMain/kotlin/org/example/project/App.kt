package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.data.repository.RecetaRepoImp
import org.example.project.domain.usecase.EditReceta
import org.example.project.domain.usecase.GetFavRecetaList
import org.example.project.domain.usecase.GetRecetaList
import org.example.project.presentation.viewmodel.RecetarioViewModel
import org.example.project.presentation.view.RecetarioV


@Composable
fun App() {
    MaterialTheme {
        val viewModel: RecetarioViewModel = viewModel {
            var repo = RecetaRepoImp()
            var getRecetaList = GetRecetaList(repo)
            var getFavRecetaList = GetFavRecetaList(repo)
            var editReceta = EditReceta(repo)
            RecetarioViewModel(getRecetaList,getFavRecetaList,editReceta)
        }
        RecetarioV(viewModel = viewModel)
    }
}