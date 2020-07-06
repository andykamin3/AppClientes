package com.example.appclientes2.Entities

class Routine(name: String?,imageUrl: String?, bodyPart: String?, duration: Int?, intensity : String?
             //,professor: String, level: String
             ) {

    var name: String = "name"
    var intensity: String = "intensify"
    var bodyPart: String = "bodypart"
  //  lateinit var professor: String
  //  lateinit var level: String
    var duration: Int = 230
    var imageUrl: String = "imageUrl"

    init{
        this.name = name!!
        this.intensity = intensity!!
        this.bodyPart = bodyPart!!
      //this.professor = professor
      //this.level = objective
        this.duration = duration!!
        this.imageUrl = imageUrl!!

    }
}