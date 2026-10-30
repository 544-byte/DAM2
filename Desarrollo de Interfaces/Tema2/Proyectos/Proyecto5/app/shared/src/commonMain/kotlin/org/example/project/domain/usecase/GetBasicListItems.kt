package org.example.project.domain.usecase

import org.example.project.domain.repository.BasicRepository
import org.example.project.models.BasicModel

class GetBasicListItems(
    private val repository: BasicRepository
){
    suspend operator fun invoke(): List<BasicModel> {
        return repository.getBasicList()
    }
}