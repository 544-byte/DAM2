package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.example.project.models.Receta
import org.example.project.states.Recetario

class RecetarioVM : ViewModel() {
    private val _uiState = MutableStateFlow(Recetario(listOf(
        Receta("Tortilla de patatas", "Principal", 30, true),
        Receta("Ensalada César", "Entrante", 15, false),
        Receta("Paella valenciana", "Principal", 60, true),
        Receta("Tostada con tomate", "Desayuno", 10, true),
        Receta("Tarta de queso", "Postre", 45, true),
        Receta("Gazpacho andaluz", "Entrante", 20, false),
        Receta("Croquetas de jamón", "Tapa", 40, false)
    )))
    val uiState : StateFlow<Recetario> = _uiState.asStateFlow()


}