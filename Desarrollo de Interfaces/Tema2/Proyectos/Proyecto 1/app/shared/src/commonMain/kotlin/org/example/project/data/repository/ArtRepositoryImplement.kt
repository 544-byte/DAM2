package org.example.project.data.repository

import org.example.project.data.dto.ArtDTO
import org.example.project.data.mapper.toModel
import org.example.project.domain.model.ArtModel
import org.example.project.domain.repository.ArtRepository

class ArtRepositoryImplement: ArtRepository {
    val items : MutableList<ArtDTO> = mutableListOf(
        ArtDTO(
            1,
            "La Gioconda",
            "Leonardo da Vinci",
            1503,
            "Retrato de Lisa Gherardini, esposa del mercader florentino Francesco del Giocondo. Leonardo nunca lo entrego y lo llevo consigo hasta su muerte en 1519. Destaca el sfumato y la sonrisa ambigua."
        ),
        ArtDTO(
            2,
            "El grito",
            "Edvard Munch",
            1893,
            "Pintado en Oslo durante una crisis de ansiedad. La figura que aparece en el centro se ha convertido en el emblema de la angustia universal ante la muerte."
        ),
        ArtDTO(
            3,
            "La noche estrellada",
            "Vincent van Gogh",
            1889,
            "Pintado en el asylum de Saint-Remy-de-Provence. El cielo en espiral y los cipresses en primer plano anticipan el expresionismo."
        ),
        ArtDTO(
            4,
            "Las Meninas",
            "Diego Velazquez",
            1656,
            "La infanta Margarita Teresa rodeada de su sequito en el alcazar del Buen Retiro. Velazquez se incluye a si mismo pintando, junto a un espejo que refleja a los reyes."
        ),
        ArtDTO(
            5,
            "La persistencia de la memoria",
            "Salvador Dali",
            1931,
            "Los relojes blandos se derriten sobre un paisaje onirico de Cap de Creus, en Cadaques. Es la obra mas famosa del surrealismo, inspirada por su interes por la memoria y el tiempo."
        )
    )

    override fun getArtList(): List<ArtModel> {
        return items.map {it.toModel()}
    }

}