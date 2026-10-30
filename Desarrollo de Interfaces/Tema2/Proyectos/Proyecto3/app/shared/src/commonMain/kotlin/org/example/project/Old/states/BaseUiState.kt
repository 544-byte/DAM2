package org.example.project.states

import org.example.project.models.BasicModel

data class BaseUiState(
    val items: List<BasicModel> = emptyList(),
    val selectedItem: BasicModel? = null
)