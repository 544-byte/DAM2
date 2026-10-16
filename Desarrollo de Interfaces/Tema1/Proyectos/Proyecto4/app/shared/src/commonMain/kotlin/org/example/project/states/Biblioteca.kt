package org.example.project.states

import org.example.project.models.Pelicula

data class Biblioteca(
    val peliculas : List<Pelicula> = emptyList()
) {
    fun peliculasFiltradas(filtroNombre : String, filtroGenre : String) : List<Pelicula>{
        return peliculas.filter{
            it.title.lowercase().contains(filtroNombre.lowercase()) and
            it.genre.lowercase().contains(filtroGenre.lowercase())
        }
    }
}