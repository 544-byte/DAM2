package org.example.project.presentation.state

import org.example.project.states.ParcelaState

data class ParcelaScreenState (
    val parcelas : List<ParcelaState> = emptyList()
)