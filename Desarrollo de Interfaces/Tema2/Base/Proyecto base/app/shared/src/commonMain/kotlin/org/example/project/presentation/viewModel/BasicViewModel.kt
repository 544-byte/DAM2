package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.domain.usecase.GetBasicListItems
import org.example.project.presentation.mapper.toState
import org.example.project.presentation.state.BasicState
import org.example.project.states.BasicScreenState

class BasicViewModel(
    private val getBasicListItems : GetBasicListItems
) : ViewModel() {
    private val _uiState = MutableStateFlow(BasicScreenState())
    val uiState: StateFlow<BasicScreenState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            try{
                val domainItems = getBasicListItems()
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

    fun selectItem(item: BasicState) {
        _uiState.update { currentState ->
            val items = currentState.items.map {
                if (it.title == item.title) {
                    it.copy(isSelected = !it.isSelected)
                } else {
                    it
                }
            }
            currentState.copy(items = items)
        }
    }
}