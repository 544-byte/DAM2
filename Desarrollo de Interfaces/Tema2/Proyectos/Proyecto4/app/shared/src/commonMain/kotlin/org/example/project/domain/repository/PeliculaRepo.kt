package org.example.project.domain.repository

import org.example.project.domain.model.PeliculaModel

interface PeliculaRepo {
    fun getPeliculaList() : List<PeliculaModel>
}