package org.example.project.data.repository

import org.example.project.data.mapper.toModel
import org.example.project.domain.repository.AlumnoRepository
import org.example.project.models.AlumnoDTO
import org.example.project.models.AlumnoModel

class AlumnoRepositoryImplementation : AlumnoRepository {
    val items : MutableList<AlumnoDTO> = mutableListOf(

    )

    override fun getAlumnoList(): List<AlumnoModel> {
        return items.map { it.toModel() }
    }

    override fun createAlumno(name: String, grades: List<Double>): Boolean {
        return items.add(AlumnoDTO(name,grades))
    }


}