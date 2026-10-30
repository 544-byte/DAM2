package org.example.project.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.domain.usecase.GetArtListItems
import org.example.project.presentation.mapper.toState
import org.example.project.presentation.state.ArtState
import org.example.project.states.ArtScreenState

class ArtViewModel(private val getArtListItems: GetArtListItems) : ViewModel() {
    private val _uiState = MutableStateFlow(ArtScreenState())
    val uiState: StateFlow<ArtScreenState> = _uiState.asStateFlow()

    init {
        loadArt()
    }

    fun loadArt() {
        viewModelScope.launch {
            try{
                val domainItems = getArtListItems()
                val uiItems = domainItems.map {it.toState()}

                _uiState.update { current ->
                    current.copy(
                        items = uiItems
                    )
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun selectArt(artwork: ArtState){
        _uiState.update { current ->
            current.copy(currentArtwork = artwork)
        }
    }

    fun isSelected(artwork: ArtState) : Boolean{
        if (_uiState.value.currentArtwork != null) {
            _uiState.update { current ->
                return (artwork.equals(current.currentArtwork))
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
