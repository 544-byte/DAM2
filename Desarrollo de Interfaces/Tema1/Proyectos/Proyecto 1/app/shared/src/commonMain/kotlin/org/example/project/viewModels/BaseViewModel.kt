package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.BasicModel
import org.example.project.states.BaseUiState

class BaseViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BaseUiState())
    val uiState: StateFlow<BaseUiState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val items = listOf(
            BasicModel(1, "Elemento 1", "Descripción del primer elemento"),
            BasicModel(2, "Elemento 2", "Descripción del segundo elemento"),
            BasicModel(3, "Elemento 3", "Descripción del tercer elemento")
        )

        _uiState.update { currentState ->
            currentState.copy(items = items)
        }
    }

    fun selectItem(item: BasicModel) {
        _uiState.update { currentState ->
            currentState.copy(selectedItem = item)
        }
    }

    fun clearSelection() {
        _uiState.update { currentState ->
            currentState.copy(selectedItem = null)
        }
    }
}