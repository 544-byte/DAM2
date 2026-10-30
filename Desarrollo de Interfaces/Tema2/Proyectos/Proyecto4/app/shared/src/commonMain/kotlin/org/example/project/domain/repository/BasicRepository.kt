package org.example.project.domain.repository

import org.example.project.models.BasicModel

interface BasicRepository {
    fun getBasicList() : List<BasicModel>
}