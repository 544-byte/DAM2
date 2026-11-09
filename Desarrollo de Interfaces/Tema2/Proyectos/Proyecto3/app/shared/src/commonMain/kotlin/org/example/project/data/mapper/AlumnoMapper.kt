package org.example.project.data.mapper

import org.example.project.models.AlumnoDTO
import org.example.project.models.AlumnoModel

fun AlumnoDTO.toModel() : AlumnoModel{
    return AlumnoModel(
        name = this.name,
        grades = this.grades
    )
}

fun AlumnoModel.toDTO() : AlumnoDTO{
    return AlumnoDTO(
        name = this.name,
        grades = this.grades
    )
}