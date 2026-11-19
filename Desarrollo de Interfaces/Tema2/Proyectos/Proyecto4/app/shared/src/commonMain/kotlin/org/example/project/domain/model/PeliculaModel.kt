package org.example.project.domain.model

data class PeliculaModel (
    val title : String,
    val genre : String,
    val duration : Int
){
    fun legibleDuration() : String{
        var h : Int = duration/60
        var m : Int = duration%60
        return "${h}h ${m}m"
    }
}