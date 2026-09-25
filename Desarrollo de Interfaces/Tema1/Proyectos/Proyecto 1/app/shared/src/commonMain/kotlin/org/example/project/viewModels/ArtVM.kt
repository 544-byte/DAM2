package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.models.ArtM
import org.example.project.states.ArtS

class ArtVM : ViewModel() {
    private val _uiState = MutableStateFlow(ArtS())
    val uiState: StateFlow<ArtS> = _uiState.asStateFlow()

    init {
        loadArt()
    }

    fun loadArt() {
        _uiState.update { current ->
            current.copy(
                artworks = listOf(
                    ArtM(
                        1,
                        "La Gioconda",
                        "Leonardo da Vinci",
                        1503,
                        "Retrato de Lisa Gherardini, esposa del mercader florentino Francesco del Giocondo. Leonardo nunca lo entrego y lo llevo consigo hasta su muerte en 1519. Destaca el sfumato y la sonrisa ambigua."
                    ),
                    ArtM(
                        2,
                        "El grito",
                        "Edvard Munch",
                        1893,
                        "Pintado en Oslo durante una crisis de ansiedad. La figura que aparece en el centro se ha convertido en el emblema de la angustia universal ante la muerte."
                    ),
                    ArtM(
                        3,
                        "La noche estrellada",
                        "Vincent van Gogh",
                        1889,
                        "Pintado en el asylum de Saint-Remy-de-Provence. El cielo en espiral y los cipresses en primer plano anticipan el expresionismo."
                    ),
                    ArtM(
                        4,
                        "Las Meninas",
                        "Diego Velazquez",
                        1656,
                        "La infanta Margarita Teresa rodeada de su sequito en el alcazar del Buen Retiro. Velazquez se incluye a si mismo pintando, junto a un espejo que refleja a los reyes."
                    ),
                    ArtM(
                        5,
                        "La persistencia de la memoria",
                        "Salvador Dali",
                        1931,
                        "Los relojes blandos se derriten sobre un paisaje onirico de Cap de Creus, en Cadaques. Es la obra mas famosa del surrealismo, inspirada por su interes por la memoria y el tiempo."
                    )
                )
            )
        }
    }

    fun selectArt(artwork: ArtM){
        _uiState.update { current ->
            current.copy(currentArtwork = artwork)
        }
    }

    fun isSelected(artwork: ArtM) : Boolean{
        if (_uiState.value.currentArtwork != null) {
            _uiState.update { current ->
                return (artwork.id == current.currentArtwork?.id)
            }
        }
        return false
    }

    fun deselectArt (){
        _uiState.update { current ->
            current.copy(currentArtwork = null)
        }
    }

}
