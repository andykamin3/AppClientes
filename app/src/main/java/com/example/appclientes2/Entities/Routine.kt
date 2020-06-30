package com.example.appclientes2.Entities

class Routine(name: String /*intensify : String, bodyPart: String, professor: String, objective: String, duration: Int, image: String*/) {

    lateinit var name: String
   /* lateinit var intensify: String
    lateinit var bodyPart: String
    lateinit var professor: String
    lateinit var objective: String
    var duration: Int*/
    lateinit var image: String

    init{
        this.name = name
        /*this.intensify = intensify
        this.bodyPart = bodyPart
        this.professor = professor
        this.objective = objective
        this.duration = duration*/
        this.image = image

    }
}