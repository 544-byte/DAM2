package org.example.project.domain.usecase

import org.example.project.domain.model.RecetaModel
import org.example.project.domain.repository.RecetaRepo

class EditReceta(
    private val repo: RecetaRepo
) {
    suspend operator fun invoke(name : String, cat: String, tiempo: Int, fav: Boolean) {
        repo.editReceta(name,cat,tiempo,fav)
    }

}