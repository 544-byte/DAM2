package org.example.project.domain.model

data class ArtModel (
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