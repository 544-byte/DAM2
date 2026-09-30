package org.example.project.models

import kotlin.compareTo

data class ArtM (
    val id : Int,
    val title: String,
    val artist: String,
    val year: Int,
    val desc: String
){
    fun isHistoric() : Boolean {
        return year < 1800
    }
}