package org.example.project.presentation.state

import org.example.project.domain.model.ArtModel

data class ArtState(
    val title: String,
    val artist: String,
    val year: Int,
    val desc: String,
    val isHistoric: String
) {

}
