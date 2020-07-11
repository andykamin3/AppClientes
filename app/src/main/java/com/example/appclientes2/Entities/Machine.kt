package com.example.appclientes2.Entities

class Machine(id: Int?, name: String?, recommendedWeight: String?, bodyPart: String?, repetitions: Int?, imageUrl: String?, level : Int?
) {

     var name: String = "Nombre"
     var recommendedWeight : String = "25,5 kg"
     var bodyPart: String = "Parte del cuerpo"
     var repetitions: Int = 12
     var imageUrl: String = "imageUrl"
     var level: Int = 1
     var id: Int = 1

    init{
        this.name = name!!
        this.recommendedWeight = recommendedWeight!!
        this.bodyPart = bodyPart!!
        this.repetitions = repetitions!!
        this.imageUrl = imageUrl!!
        this.level = level!!
        this.id = id!!
    }
}