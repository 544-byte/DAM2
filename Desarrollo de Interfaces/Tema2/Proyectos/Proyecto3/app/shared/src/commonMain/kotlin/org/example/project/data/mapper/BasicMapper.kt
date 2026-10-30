package org.example.project.data.mapper

import org.example.project.data.dto.BasicDTO
import org.example.project.models.BasicModel

fun BasicDTO.toModel() : BasicModel {
    return BasicModel(
        id = this.id,
        title = this.titulo,
        description = this.descripcion
    )
}

fun BasicModel.toDTO() : BasicDTO {
    return BasicDTO(
        id = this.id,
        titulo = this.title,
        descripcion = this.description
    )
}