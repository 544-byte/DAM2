package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.example.project.domain.usecase.GetParcelaListItems
import org.example.project.presentation.mapper.toState
import org.example.project.presentation.state.ParcelaScreenState
import org.example.project.states.ParcelaState

class ParcelaViewModel(
    private val getParcelaListItems: GetParcelaListItems
) : ViewModel() {
    private val _uiState = MutableStateFlow(ParcelaScreenState())
    val uiState : StateFlow<ParcelaScreenState> = _uiState.asStateFlow()

    init {
        loadParcelas()
    }

    fun loadParcelas() {
        viewModelScope.launch {
            _uiState.update { current ->
                current.copy(parcelas = getParcelaListItems().map { it.toState() })
            }
        }
    }

    fun cambiarEstadoDeRiego(parcela: ParcelaState) {
        _uiState.update { current ->
            current.copy(
                parcelas = current.parcelas.map {
                    if (it == parcela) {
                        it.copy(isBeingWatered = !it.isBeingWatered)
                    } else {
                        it
                    }
                }
            )
        }
    }
}