package org.example.project.states

data class AlumnoUiState(
    val alumnos : List<AlumnoState> = emptyList(),
    val newAlumno : AlumnoState = AlumnoState("",listOf(0.0,0.0),null,null)
)
