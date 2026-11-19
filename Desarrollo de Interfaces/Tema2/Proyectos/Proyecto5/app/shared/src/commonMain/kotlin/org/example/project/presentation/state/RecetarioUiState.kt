package org.example.project.presentation.state

data class RecetarioUiState(
    val recetas : List<RecetaState> = emptyList(),
    val soloFav : Boolean = false
)
