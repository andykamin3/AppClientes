package com.example.appclientes2.Entities

class Routine(name: String?//, intensify : String?, bodyPart: String?, duration: Int?, image: String?
             //,professor: String, objective: String
             ) {

    var name: String = "name"
    /*var intensify: String = "intensify"
    var bodyPart: String = "bodypart"
    lateinit var professor: String
    lateinit var objective: String
    var duration: Int = 230
    var image: String = "image" */

    init{
        this.name = name!!
      /*  this.intensify = intensify!!
        this.bodyPart = bodyPart!!
      //this.professor = professor
      //this.objective = objective
        this.duration = duration!!
        this.image = image!!
        */
    }
}