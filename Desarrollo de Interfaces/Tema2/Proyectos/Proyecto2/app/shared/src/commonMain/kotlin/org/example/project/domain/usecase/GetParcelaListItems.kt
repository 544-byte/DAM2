package org.example.project.domain.usecase

import org.example.project.domain.repository.ParcelaRepository
import org.example.project.models.ParcelaModel

class GetParcelaListItems(
    private val repository: ParcelaRepository
) {
    suspend operator fun invoke() : List<ParcelaModel> {
        return repository.getParcelaList()
    }
}