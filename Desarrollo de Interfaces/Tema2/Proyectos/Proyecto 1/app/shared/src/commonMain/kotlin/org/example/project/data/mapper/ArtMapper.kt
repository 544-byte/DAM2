package org.example.project.data.mapper

import org.example.project.data.dto.ArtDTO
import org.example.project.domain.model.ArtModel

fun ArtDTO.toModel() : ArtModel {
    return ArtModel(
        id = this.id,
        title = this.title,
        artist = this.artist,
        year = this.year,
        desc = this.desc
    )
}

fun ArtModel.toDTO() : ArtDTO {
    return ArtDTO(
        id = this.id,
        title = this.title,
        artist = this.artist,
        year = this.year,
        desc = this.desc
    )
}