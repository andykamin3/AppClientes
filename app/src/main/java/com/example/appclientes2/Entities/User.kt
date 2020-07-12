package com.example.appclientes2.Entities

import android.widget.ListAdapter

class User(name : String, birthDate : String, weight: Double, height: Int, objective: String,// favorite: ListAdapter,id: Int
           image: String, localidad : String) {

    lateinit var name: String
    lateinit var birthDate: String
    var weight: Double
    var height: Int
    lateinit var objective: String
 //   lateinit var favorite: ListAdapter
 //   lateinit var id : Int
    lateinit var image: String
    lateinit var localidad: String

    init{
        this.name = name
        this.birthDate = birthDate
        this.weight = weight
        this.height = height
        this.objective = objective
//        this.favorite = favorite
        // this.id = id
        this.image = image
        this.localidad= localidad

    }
}