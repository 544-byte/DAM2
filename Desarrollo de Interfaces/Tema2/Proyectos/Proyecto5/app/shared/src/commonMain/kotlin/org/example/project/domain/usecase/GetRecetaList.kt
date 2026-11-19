package org.example.project.domain.usecase

import org.example.project.domain.model.RecetaModel
import org.example.project.domain.repository.RecetaRepo

class GetRecetaList(
    private val repo : RecetaRepo
) {
    suspend operator fun invoke() : List<RecetaModel>{
        return repo.getRecetaList()
    }
}