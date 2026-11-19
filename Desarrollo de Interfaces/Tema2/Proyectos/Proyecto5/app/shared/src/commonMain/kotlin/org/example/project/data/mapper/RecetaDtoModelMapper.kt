package org.example.project.data.mapper

import org.example.project.data.dto.RecetaDTO
import org.example.project.domain.model.RecetaModel

fun RecetaDTO.toModel() : RecetaModel{
    return RecetaModel(
        nombre = nombre,
        categoria = categoria,
        tiempoPreparacion = tiempoPreparacion,
        favorita = favorita
    )
}

fun RecetaModel.toDTO() : RecetaDTO{
    return RecetaDTO(
        nombre = nombre,
        categoria = categoria,
        tiempoPreparacion = tiempoPreparacion,
        favorita = favorita
    )
}