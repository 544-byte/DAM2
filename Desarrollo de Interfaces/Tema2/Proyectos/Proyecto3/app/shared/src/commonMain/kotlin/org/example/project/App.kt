package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.data.repository.AlumnoRepositoryImplementation
import org.example.project.domain.usecase.CreateAlumno
import org.example.project.domain.usecase.GetAlumnoList
import org.example.project.viewModels.AlumnoViewModel
import org.example.project.views.Formulario

@Composable
fun App() {
    MaterialTheme {
        val viewModel: AlumnoViewModel = viewModel {
            var repository = AlumnoRepositoryImplementation()
            var getAlumnoList = GetAlumnoList(repository)
            var createAlumno = CreateAlumno(repository)
            AlumnoViewModel(getAlumnoList, createAlumno)
        }
        Formulario(viewModel = viewModel)
    }
}