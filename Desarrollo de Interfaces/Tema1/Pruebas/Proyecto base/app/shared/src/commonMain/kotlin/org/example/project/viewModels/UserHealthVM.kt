package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.states.UserHealthState

class UserHealthVM : ViewModel() {
    private val _uiState = MutableStateFlow(UserHealthState())
    val uiState: StateFlow<UserHealthState> = _uiState.asStateFlow()

    fun objetivo(): Boolean {
        val userHealth = uiState.value.userHealth

        return userHealth !== null && userHealth.nPasos!! >= 10000
    }

    fun sumarPasos() {
        _uiState.update { state ->
            val user = state.userHealth ?: return@update state
            state.copy(userHealth = user.copy(nPasos = user.nPasos + 1000))
        }
    }
}