package org.example.project.data.repository

import org.example.project.data.dto.PeliculaDTO
import org.example.project.data.mapper.toModel
import org.example.project.domain.model.PeliculaModel
import org.example.project.domain.repository.PeliculaRepo

class PeliculaRepoImp : PeliculaRepo {
    val items = mutableListOf<PeliculaDTO>(
            PeliculaDTO("El Padrino", "Drama", 175),
            PeliculaDTO("Titanic", "Romance", 194),
            PeliculaDTO("Gladiator", "Acción", 155),
            PeliculaDTO("Inception", "Ciencia Ficción", 148),
            PeliculaDTO("Interstellar", "Ciencia Ficción", 169),
            PeliculaDTO("Avatar", "Fantasía", 162),
            PeliculaDTO("Joker", "Drama", 122),
            PeliculaDTO("Deadpool", "Comedia", 108),
            PeliculaDTO("Matrix", "Ciencia Ficción", 136),
            PeliculaDTO("Rocky", "Drama", 120),
            PeliculaDTO("Toy Story", "Animación", 81),
            PeliculaDTO("Shrek", "Animación", 90),
            PeliculaDTO("Frozen", "Animación", 102),
            PeliculaDTO("Top Gun", "Acción", 110),
            PeliculaDTO("John Wick", "Acción", 101),
            PeliculaDTO("La La Land", "Musical", 128),
            PeliculaDTO("Whiplash", "Drama", 107),
            PeliculaDTO("Coco", "Animación", 105),
            PeliculaDTO("Dune", "Ciencia Ficción", 155),
            PeliculaDTO("El Caballero Oscuro", "Acción", 152)
        )

    override fun getPeliculaList() : List<PeliculaModel> {
        return items.map { it.toModel() }
    }
}