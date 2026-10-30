package org.example.project.domain.repository

import org.example.project.domain.model.ArtModel

interface ArtRepository {
    fun getArtList() : List<ArtModel>
}