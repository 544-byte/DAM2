package org.example.project.states

import org.example.project.models.Receta

data class Recetario(
    val recetas : List<Receta> = emptyList(),
    val recetasFav: List<Receta> = recetas.filter { it.favorita },
)
