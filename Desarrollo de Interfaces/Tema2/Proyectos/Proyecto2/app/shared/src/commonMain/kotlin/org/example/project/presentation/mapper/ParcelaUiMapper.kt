package org.example.project.presentation.mapper

import org.example.project.models.ParcelaModel
import org.example.project.states.ParcelaState

fun ParcelaModel.toState() : ParcelaState {
    return ParcelaState(
        name = this.name,
        cropType = this.cropType,
        surface = this.surface,
        needsWater = this.needsWater,
        isBeingWatered = this.isBeingWatered,
        waterNeeded = this.waterNeeded()
    )
}
