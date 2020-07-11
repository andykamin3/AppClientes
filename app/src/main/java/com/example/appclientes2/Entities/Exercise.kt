package com.example.appclientes2.Entities

class Exercise(id : Int?, name: String?, duration : String, level : String, imageUrl : String?
               //, repetitions : Int
){
    var id : Int = 1
    var name : String = "Ejercicio 1"
    var duration : String = "1"
    var level : String = "principiante"
    var imageUrl : String = ""
    //var repetitions : Int = 1

    init{
        this.id = id!!
        this.name = name!!
        this.duration = duration!!
        this.level = level!!
        this.imageUrl = imageUrl!!
        //this.repetitions = repetitions!!
    }
}