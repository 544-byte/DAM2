package org.example.project.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*
import org.example.project.models.ParcelaM
import org.example.project.states.ParcelaS

class ParcelaVM : ViewModel() {
    private val _uiState = MutableStateFlow(ParcelaS(
        parcelas = listOf(
            ParcelaM(
                id = 1,
                name = "Parcela Norte",
                cropType = "Tomates",
                surface = 120.5,
                needsWater = true,
                isBeingWatered = false
            ),
            ParcelaM(
                id = 2,
                name = "Zona Delantera",
                cropType = "Lechugas",
                surface = 85.0,
                needsWater = false,
                isBeingWatered = true
            ),
            ParcelaM(
                id = 3,
                name = "Huerto Viejo",
                cropType = "Patatas",
                surface = 200.0,
                needsWater = false,
                isBeingWatered = false
            ),
            ParcelaM(
                id = 4,
                name = "Invernadero A",
                cropType = "Fresas",
                surface = 50.2,
                needsWater = true,
                isBeingWatered = true
            ),
            ParcelaM(
                id = 5,
                name = "Parcela Sur",
                cropType = "Zanahorias",
                surface = 150.0,
                needsWater = true,
                isBeingWatered = false
            ),
            ParcelaM(
                id = 1,
                name = "Parcela Norte",
                cropType = "Tomates",
                surface = 120.5,
                needsWater = true,
                isBeingWatered = false
            ),
            ParcelaM(
                id = 2,
                name = "Zona Delantera",
                cropType = "Lechugas",
                surface = 85.0,
                needsWater = false,
                isBeingWatered = true
            ),
            ParcelaM(
                id = 3,
                name = "Huerto Viejo",
                cropType = "Patatas",
                surface = 200.0,
                needsWater = false,
                isBeingWatered = false
            ),
            ParcelaM(
                id = 4,
                name = "Invernadero A",
                cropType = "Fresas",
                surface = 50.2,
                needsWater = true,
                isBeingWatered = true
            ),
            ParcelaM(
                id = 5,
                name = "Parcela Sur",
                cropType = "Zanahorias",
                surface = 150.0,
                needsWater = true,
                isBeingWatered = false
            )


        )
    ))
    val uiState : StateFlow<ParcelaS> = _uiState.asStateFlow()

}