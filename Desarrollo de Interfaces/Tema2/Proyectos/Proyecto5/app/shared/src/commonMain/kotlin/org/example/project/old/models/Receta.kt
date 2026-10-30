package org.example.project.models

data class Receta(
    val nombre : String,
    val categoria : String,
    val tiempoPreparacion : Int,
    val favorita : Boolean
){
    fun esRapida() : Boolean {
        return tiempoPreparacion <= 20
    }
}