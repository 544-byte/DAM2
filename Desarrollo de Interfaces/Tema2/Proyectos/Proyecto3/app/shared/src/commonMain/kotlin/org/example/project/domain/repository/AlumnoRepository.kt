package org.example.project.domain.repository

import org.example.project.models.AlumnoModel


interface AlumnoRepository {
    fun getAlumnoList() : List<AlumnoModel>

    fun createAlumno(name: String, grades: List<Double>) : Boolean
}