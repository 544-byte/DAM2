package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.example.project.models.Pelicula
import org.example.project.states.Biblioteca

class BibliotecaVM : ViewModel() {
    private val _uiState = MutableStateFlow(Biblioteca(listOf(
        Pelicula("El Padrino", "Drama", 175),
        Pelicula("Titanic", "Romance", 194),
        Pelicula("Gladiator", "Acción", 155),
        Pelicula("Inception", "Ciencia Ficción", 148),
        Pelicula("Interstellar", "Ciencia Ficción", 169),
        Pelicula("Avatar", "Fantasía", 162),
        Pelicula("Joker", "Drama", 122),
        Pelicula("Deadpool", "Comedia", 108),
        Pelicula("Matrix", "Ciencia Ficción", 136),
        Pelicula("Rocky", "Drama", 120),
        Pelicula("Toy Story", "Animación", 81),
        Pelicula("Shrek", "Animación", 90),
        Pelicula("Frozen", "Animación", 102),
        Pelicula("Top Gun", "Acción", 110),
        Pelicula("John Wick", "Acción", 101),
        Pelicula("La La Land", "Musical", 128),
        Pelicula("Whiplash", "Drama", 107),
        Pelicula("Coco", "Animación", 105),
        Pelicula("Dune", "Ciencia Ficción", 155),
        Pelicula("El Caballero Oscuro", "Acción", 152)    )))
    val uiState : StateFlow<Biblioteca> = _uiState.asStateFlow()


}