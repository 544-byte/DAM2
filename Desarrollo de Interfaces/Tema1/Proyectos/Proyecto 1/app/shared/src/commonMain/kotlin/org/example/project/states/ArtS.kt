package org.example.project.states

import org.example.project.models.ArtM

data class ArtS(
    val artworks: List<ArtM>? = null,
    val currentArtwork: ArtM? = null
)
