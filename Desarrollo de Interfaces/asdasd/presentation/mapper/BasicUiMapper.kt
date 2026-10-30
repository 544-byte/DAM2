package org.example.project.presentation.mapper

import org.example.project.models.BasicModel
import org.example.project.presentation.state.BasicState

fun BasicModel.toState() : BasicState {
    return BasicState(
        title = this.title,
        description = this.description
    )
}