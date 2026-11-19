package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.data.repository.PeliculaRepoImp
import org.example.project.domain.usecase.GetPeliculaList
import org.example.project.presentation.viewmodel.BibliotecaVM
import org.example.project.presentation.view.Buscador


@Composable
fun App() {
    MaterialTheme {
        val viewModel: BibliotecaVM = viewModel {
            var repo = PeliculaRepoImp()
            var getPeliculaList = GetPeliculaList(repo)
            BibliotecaVM(getPeliculaList)
        }
        Buscador(viewModel = viewModel)
    }
}