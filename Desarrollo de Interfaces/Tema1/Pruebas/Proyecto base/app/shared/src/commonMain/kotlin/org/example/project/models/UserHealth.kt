package org.example.project.models

data class UserHealth(
    var peso: Double,
    var altura: Double,
    var nPasos: Int
) {

    fun imc(): Double {
        return peso * (altura * altura)
    }
}