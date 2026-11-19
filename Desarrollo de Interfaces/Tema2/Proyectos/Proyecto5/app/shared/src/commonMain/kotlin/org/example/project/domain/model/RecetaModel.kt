package org.example.project.domain.model

data class RecetaModel(
    val nombre : String,
    val categoria : String,
    val tiempoPreparacion : Int,
    val favorita : Boolean
){
    fun esRapida() : Boolean {
        return tiempoPreparacion <= 20
    }
}