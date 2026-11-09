package org.example.project.presentation.mapper

import org.example.project.models.AlumnoModel
import org.example.project.states.AlumnoState

fun AlumnoModel.toState() : AlumnoState {
    return AlumnoState(
        name = this.name,
        grades = this.grades,
        finalGrade = this.finalGrade(),
        didPass = this.didPass()
    )
}