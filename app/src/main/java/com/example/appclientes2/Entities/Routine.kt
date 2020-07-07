package com.example.appclientes2.Entities

class Routine(name: String?,imageUrl: String?, bodyPart: String?, duration: Int?, level: String?
             //,professor: String?, intensity : String?, id: Int?
             ) {
    var name: String = "name"
    var intensity: String = "intensify"
    var bodyPart: String = "bodypart"
    //lateinit var professor: String
    //lateinit var level: String
    //lateinit var id: Int
    var duration: Int = 230
    var imageUrl: String = "imageUrl"

    init{
        this.name = name!!
        this.intensity = intensity!!
        this.bodyPart = bodyPart!!
        //this.professor = professor
        //this.level = objective
        //this.id = id
        this.duration = duration!!
        this.imageUrl = imageUrl!!

    }
}