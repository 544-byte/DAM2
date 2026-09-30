package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*
import org.example.project.states.ParcelaS

class ParcelaVM : ViewModel() {

    private val _uiState = MutableStateFlow(ParcelaS())
    val uiState : StateFlow<ParcelaS> = _uiState.asStateFlow()
}