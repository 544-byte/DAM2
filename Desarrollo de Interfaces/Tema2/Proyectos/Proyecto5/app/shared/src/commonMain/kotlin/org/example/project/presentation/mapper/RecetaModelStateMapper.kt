package org.example.project.presentation.mapper

import org.example.project.domain.model.RecetaModel
import org.example.project.presentation.state.RecetaState

fun RecetaModel.toState() : RecetaState {
    return RecetaState(
        nombre = nombre,
        categoria = categoria,
        tiempoPreparacion = tiempoPreparacion,
        favorita = favorita,
        esRapida = esRapida()
    )
}