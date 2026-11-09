package org.example.project.states

data class AlumnoState(
    val name : String,
    val grades : List<Double>,
    val finalGrade : Double?,
    val didPass : Boolean?
)