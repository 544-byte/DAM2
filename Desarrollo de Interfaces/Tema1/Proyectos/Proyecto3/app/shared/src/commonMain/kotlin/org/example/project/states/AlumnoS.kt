package org.example.project.states

import org.example.project.models.Alumno

data class AlumnoS(
    val alumnos : List<Alumno> = emptyList(),
    val newAlumno : Alumno = Alumno("",listOf(0.0,0.0))
)
