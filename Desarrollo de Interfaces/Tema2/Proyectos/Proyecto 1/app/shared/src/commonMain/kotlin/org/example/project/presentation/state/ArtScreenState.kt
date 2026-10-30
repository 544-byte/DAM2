package org.example.project.states

import org.example.project.presentation.state.ArtState

data class ArtScreenState(
    val items: List<ArtState> = emptyList(),
    val currentArtwork : ArtState? = null
)