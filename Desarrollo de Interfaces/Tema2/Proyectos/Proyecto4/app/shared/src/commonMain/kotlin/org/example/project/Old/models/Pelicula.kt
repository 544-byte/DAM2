package org.example.project.models

data class Pelicula (
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