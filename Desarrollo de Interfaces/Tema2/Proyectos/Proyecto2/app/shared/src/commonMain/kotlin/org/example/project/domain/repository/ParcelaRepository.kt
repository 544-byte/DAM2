package org.example.project.domain.repository

import org.example.project.models.ParcelaModel

interface ParcelaRepository {
    fun getParcelaList() : List<ParcelaModel>
}