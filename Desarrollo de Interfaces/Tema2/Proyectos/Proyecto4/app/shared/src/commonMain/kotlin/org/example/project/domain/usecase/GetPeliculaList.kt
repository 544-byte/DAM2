package org.example.project.domain.usecase

import org.example.project.domain.model.PeliculaModel
import org.example.project.domain.repository.PeliculaRepo

class GetPeliculaList(
    private val repo : PeliculaRepo
) {
    suspend operator fun invoke() : List<PeliculaModel>{
        return repo.getPeliculaList()
    }
}