package org.example.project.presentation.mapper

import org.example.project.domain.model.PeliculaModel
import org.example.project.presentation.state.PeliculaState

fun PeliculaModel.toState() : PeliculaState {
    return PeliculaState(
        title = title,
        genre = genre,
        duration = duration,
        legibleDuration = legibleDuration()
    )
}