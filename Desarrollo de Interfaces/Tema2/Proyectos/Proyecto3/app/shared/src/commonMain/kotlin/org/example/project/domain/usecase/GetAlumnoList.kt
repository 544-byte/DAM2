package org.example.project.domain.usecase

import org.example.project.domain.repository.AlumnoRepository
import org.example.project.models.AlumnoModel

class GetAlumnoList(
    private val repository : AlumnoRepository
) {
    suspend operator fun invoke() : List<AlumnoModel> {
        return repository.getAlumnoList()
    }
}