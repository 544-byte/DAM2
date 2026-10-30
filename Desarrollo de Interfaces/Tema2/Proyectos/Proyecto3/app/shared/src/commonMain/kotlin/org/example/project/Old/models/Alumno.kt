package org.example.project.models

data class Alumno(
    val name : String,
    val grades : List<Double>,
) {
    fun finalGrade() : Double = (grades[0] * 60/100) + (grades[1] * 40/100)

    fun didPass() : Boolean = finalGrade() >= 5.0
}