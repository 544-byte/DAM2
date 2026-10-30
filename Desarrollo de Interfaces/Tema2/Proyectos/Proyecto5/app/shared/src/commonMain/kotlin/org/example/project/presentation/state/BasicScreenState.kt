package org.example.project.states

import org.example.project.models.BasicModel
import org.example.project.presentation.state.BasicState

data class BasicScreenState(
    val items: List<BasicState> = emptyList()
)