package org.example.project.states

import org.example.project.models.Pelicula

data class Biblioteca(
    val peliculas : List<Pelicula> = emptyList()
) {
}