package org.example.project.data.repository

import org.example.project.data.dto.RecetaDTO
import org.example.project.data.mapper.toModel
import org.example.project.domain.model.RecetaModel
import org.example.project.domain.repository.RecetaRepo

class RecetaRepoImp : RecetaRepo {
    var items = listOf(
        RecetaDTO("Tortilla de patatas", "Principal", 30, true),
        RecetaDTO("Ensalada César", "Entrante", 15, false),
        RecetaDTO("Paella valenciana", "Principal", 60, true),
        RecetaDTO("Tostada con tomate", "Desayuno", 10, true),
        RecetaDTO("Tarta de queso", "Postre", 45, true),
        RecetaDTO("Gazpacho andaluz", "Entrante", 20, false),
        RecetaDTO("Croquetas de jamón", "Tapa", 40, false)
    )

    override fun getRecetaList(): List<RecetaModel> {
        return items.map { it.toModel() }
    }

    override fun getFavRecetaList(): List<RecetaModel> {
        return items.filter { it.favorita }.map { it.toModel() }
    }

    override fun editReceta(name: String, cat: String, tiempo: Int, fav: Boolean) {
        items = items.map { if (it.nombre == name) it.copy(categoria = cat, tiempoPreparacion = tiempo, favorita = fav) else it}
    }

}