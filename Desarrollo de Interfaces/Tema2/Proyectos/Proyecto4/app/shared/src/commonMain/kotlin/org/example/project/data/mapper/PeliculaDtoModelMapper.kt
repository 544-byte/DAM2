package org.example.project.data.mapper

import org.example.project.domain.model.PeliculaModel
import org.example.project.data.dto.PeliculaDTO

fun PeliculaDTO.toModel() : PeliculaModel {
    return PeliculaModel(
        title = title,
        genre = genre,
        duration = duration
    )
}

fun PeliculaModel.toDTO() : PeliculaDTO {
    return PeliculaDTO(
        title = title,
        genre = genre,
        duration = duration
    )
}