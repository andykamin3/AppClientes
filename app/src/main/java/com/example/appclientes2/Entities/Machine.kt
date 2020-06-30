package com.example.appclientes2.Entities

class Machine(name: String, recommendedWeight: Double, bodyPart: String, repetitions: Int, image: String) {

    lateinit var name: String
    var recommendedWeight : Double
    lateinit var bodyPart: String
    var repetitions: Int
    lateinit var image: String

    init{
        this.name = name
        this.recommendedWeight = recommendedWeight
        this.bodyPart = bodyPart
        this.repetitions = repetitions
        this.image = image

    }
}