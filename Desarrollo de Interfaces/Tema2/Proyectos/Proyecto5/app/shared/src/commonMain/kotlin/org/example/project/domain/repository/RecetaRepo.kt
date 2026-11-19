package org.example.project.domain.repository

import org.example.project.domain.model.RecetaModel

interface RecetaRepo {
    fun getRecetaList() : List<RecetaModel>
    fun getFavRecetaList() : List<RecetaModel>
    fun editReceta(name : String, cat: String, tiempo: Int, fav: Boolean)
}