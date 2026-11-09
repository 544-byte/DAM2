package org.example.project.domain.usecase

import org.example.project.domain.repository.AlumnoRepository
import org.example.project.states.AlumnoState

class CreateAlumno(
    private val repository: AlumnoRepository
) {
    suspend operator fun invoke(alumnoState: AlumnoState) : Boolean{
        return repository.createAlumno(alumnoState.name,alumnoState.grades)
    }
}