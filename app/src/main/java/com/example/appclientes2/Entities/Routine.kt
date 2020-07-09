package com.example.appclientes2.Entities

class Routine(id: Int?, name: String?,imageUrl: String?, bodyPart: String?, duration: Int?, level: String?, professor: String?
             //, intensity : String?
             ){
    var name: String = "name"
    var bodyPart: String = "bodypart"
    var level: String = "Level"
    var id: Int = 1
    var duration: Int = 230
    var imageUrl: String = "imageUrl"
    // var intensity: String = "intensity"
    var professor: String = "Profesor 1"

    init{
        this.name = name!!
        this.bodyPart = bodyPart!!
        this.level = level!!
        this.id = id!!
        this.duration = duration!!
        this.imageUrl = imageUrl!!
        //this.intensity = intensity!!
        this.professor = professor!!

    }
}