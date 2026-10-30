package org.example.project.domain.usecase

import org.example.project.domain.repository.ArtRepository
import org.example.project.domain.model.ArtModel

class GetArtListItems(
    private val repository: ArtRepository
){
    suspend operator fun invoke(): List<ArtModel> {
        return repository.getArtList()
    }
}