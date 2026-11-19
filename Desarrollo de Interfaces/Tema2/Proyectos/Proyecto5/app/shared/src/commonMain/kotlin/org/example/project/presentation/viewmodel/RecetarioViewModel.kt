package org.example.project.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.domain.usecase.EditReceta
import org.example.project.domain.usecase.GetFavRecetaList
import org.example.project.domain.usecase.GetRecetaList
import org.example.project.presentation.mapper.toState
import org.example.project.presentation.state.RecetaState
import org.example.project.presentation.state.RecetarioUiState

class RecetarioViewModel(
    private var getRecetaList: GetRecetaList,
    private var getFavRecetaList: GetFavRecetaList,
    private var editReceta: EditReceta
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecetarioUiState())
    val uiState : StateFlow<RecetarioUiState> = _uiState.asStateFlow()

    init {
        cargarRecetas()
    }

    private fun cargarRecetas() {
        viewModelScope.launch {
            _uiState.update { current ->
                if (!current.soloFav) current.copy(getRecetaList().map{ it.toState() })
                else
                    current.copy(getFavRecetaList().map { it.toState() })
            }
        }
    }

    fun switchFavoritas(){
        _uiState.update { it.copy(soloFav = !it.soloFav) }
        cargarRecetas()
    }

    fun setFav(receta : RecetaState) {
        viewModelScope.launch{
            editReceta(receta.nombre,receta.categoria,receta.tiempoPreparacion,!receta.favorita)
            cargarRecetas()
        }
    }

}