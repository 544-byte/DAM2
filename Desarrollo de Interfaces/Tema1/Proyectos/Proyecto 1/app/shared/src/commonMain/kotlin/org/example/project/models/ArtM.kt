package org.example.project.models

data class ArtM (
    val id : Int,
    val title: String,
    val artist: String,
    val year: Int,
    val desc: String
){
    fun isHistoric() : Boolean {
        return year <= 1900
    }
}