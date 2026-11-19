package org.example.project.presentation.state

data class Biblioteca(
    val peliculas : List<PeliculaState> = emptyList()
) {
    fun peliculasFiltradas(filtroNombre : String, filtroGenre : String) : List<PeliculaState>{
        return peliculas.filter{
            it.title.lowercase().contains(filtroNombre.lowercase()) and
            it.genre.lowercase().contains(filtroGenre.lowercase())
        }
    }
}