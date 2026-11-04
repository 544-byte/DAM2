package org.example.project.data.repository

import org.example.project.data.mapper.toModel
import org.example.project.domain.repository.ParcelaRepository
import org.example.project.models.ParcelaDTO
import org.example.project.models.ParcelaModel

class ParcelaRepositoryImplement : ParcelaRepository {
    val parcelasDTO : MutableList<ParcelaDTO> = mutableListOf(
        ParcelaDTO(
            id = 1,
            name = "Parcela Norte",
            cropType = "Tomates",
            surface = 120.5,
            needsWater = true,
            isBeingWatered = false
        ),
        ParcelaDTO(
            id = 2,
            name = "Zona Delantera",
            cropType = "Lechugas",
            surface = 85.0,
            needsWater = false,
            isBeingWatered = true
        ),
        ParcelaDTO(
            id = 3,
            name = "Huerto Viejo",
            cropType = "Patatas",
            surface = 200.0,
            needsWater = false,
            isBeingWatered = false
        ),
        ParcelaDTO(
            id = 4,
            name = "Invernadero A",
            cropType = "Fresas",
            surface = 50.2,
            needsWater = true,
            isBeingWatered = true
        ),
        ParcelaDTO(
            id = 5,
            name = "Parcela Sur",
            cropType = "Zanahorias",
            surface = 150.0,
            needsWater = true,
            isBeingWatered = false
        ),
        ParcelaDTO(
            id = 6,
            name = "Parcela Norte",
            cropType = "Tomates",
            surface = 120.0,
            needsWater = true,
            isBeingWatered = false
        )
    )

    override fun getParcelaList() : List<ParcelaModel>{
        return parcelasDTO.map {
            item -> item.toModel()
        }
    }
}