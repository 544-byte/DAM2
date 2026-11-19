package org.example.project.presentation.state

data class RecetaState(
    val nombre : String,
    val categoria : String,
    val tiempoPreparacion : Int,
    val favorita : Boolean,
    val esRapida : Boolean
)