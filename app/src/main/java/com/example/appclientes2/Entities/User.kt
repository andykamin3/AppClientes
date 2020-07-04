package com.example.appclientes2.Entities

import android.widget.ListAdapter

class User(name : String, birthDate : String, weight: Double, height: Int, objective: String,// favorite: ListAdapter,
           image: String) {

    lateinit var name: String
    lateinit var birthDate: String
    var weight: Double
    var height: Int
    lateinit var objective: String
 //   lateinit var favorite: ListAdapter
    lateinit var image: String

    init{
        this.name = name
        this.birthDate = birthDate
        this.weight = weight
        this.height = height
        this.objective = objective
//        this.favorite = favorite
        this.image = image

    }
}