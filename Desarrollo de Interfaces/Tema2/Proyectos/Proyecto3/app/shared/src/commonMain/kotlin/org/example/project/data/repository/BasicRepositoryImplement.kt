package org.example.project.data.repository

import org.example.project.data.dto.BasicDTO
import org.example.project.data.mapper.toModel
import org.example.project.domain.repository.BasicRepository
import org.example.project.models.BasicModel

class BasicRepositoryImplement: BasicRepository {
    val items : MutableList<BasicDTO> = mutableListOf(
        BasicDTO(1,"hola1","Saludo 1"),
        BasicDTO(2,"hola2","Saludo 2"),
        BasicDTO(3,"hola3","Saludo 3"),
        BasicDTO(4,"hola4","Saludo 4")
    )

    override fun getBasicList(): List<BasicModel> {
        return items.map {it.toModel()}
    }

}