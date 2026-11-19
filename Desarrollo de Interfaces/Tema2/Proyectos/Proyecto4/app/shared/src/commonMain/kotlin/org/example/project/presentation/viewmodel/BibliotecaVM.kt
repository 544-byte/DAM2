package org.example.project.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.domain.model.PeliculaModel
import org.example.project.domain.repository.PeliculaRepo
import org.example.project.domain.usecase.GetPeliculaList
import org.example.project.presentation.mapper.toState
import org.example.project.presentation.state.Biblioteca
import org.example.project.presentation.state.PeliculaState

class BibliotecaVM(
    private val getPeliculaList: GetPeliculaList
) : ViewModel() {
    private val _uiState = MutableStateFlow(Biblioteca())
    val uiState : StateFlow<Biblioteca> = _uiState.asStateFlow()

    init {
        cargarPeliculas()
    }

    private fun cargarPeliculas() {
        viewModelScope.launch {
            _uiState.update { current ->
                current.copy(peliculas = getPeliculaList().map { it.toState() })
            }
        }
    }

}