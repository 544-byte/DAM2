package org.example.project.states

data class ParcelaState(
    val name : String,
    val cropType : String,
    val surface : Double,
    val needsWater : Boolean,
    val isBeingWatered : Boolean,
    val waterNeeded : Double
)