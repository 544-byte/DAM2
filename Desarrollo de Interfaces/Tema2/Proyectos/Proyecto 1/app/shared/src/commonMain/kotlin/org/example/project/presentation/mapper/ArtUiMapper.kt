package org.example.project.presentation.mapper

import org.example.project.domain.model.ArtModel
import org.example.project.presentation.state.ArtState

fun ArtModel.toState() : ArtState {
    return ArtState(
        title = this.title,
        artist = this.artist,
        year = this.year,
        desc = this.desc,
        isHistoric = if (this.isHistoric()) "es historico" else "no es historico"
    )
}