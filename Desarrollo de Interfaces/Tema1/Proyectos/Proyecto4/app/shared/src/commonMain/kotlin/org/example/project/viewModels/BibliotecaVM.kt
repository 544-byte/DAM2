package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.example.project.states.Biblioteca

class BibliotecaVM : ViewModel() {
    private val _uiState = MutableStateFlow(Biblioteca())
    val uiState : StateFlow<Biblioteca> = _uiState.asStateFlow()


}