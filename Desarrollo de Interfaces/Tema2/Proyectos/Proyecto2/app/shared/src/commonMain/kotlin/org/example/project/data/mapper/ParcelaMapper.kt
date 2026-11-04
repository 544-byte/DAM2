package org.example.project.data.mapper

import org.example.project.models.ParcelaDTO
import org.example.project.models.ParcelaModel

fun ParcelaDTO.toModel() : ParcelaModel{
    return ParcelaModel(
        id = this.id,
        name = this.name,
        cropType = this.cropType,
        surface = this.surface,
        needsWater = this.needsWater,
        isBeingWatered = this.isBeingWatered
    )
}

fun ParcelaModel.toDTO() : ParcelaDTO{
    return ParcelaDTO(
        id = this.id,
        name = this.name,
        cropType = this.cropType,
        surface = this.surface,
        needsWater = this.needsWater,
        isBeingWatered = this.isBeingWatered
    )
}