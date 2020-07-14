package com.example.appclientes2.Entities

import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class User(name : String, birthDate : String, weight: Double, height: Int, objective: String, favoriteRoutines: MutableList<Routine>,
           //id: Int,
           image: String, location : String) {

    lateinit var name: String
    lateinit var birthDate: String
    var weight: Double
    var height: Int
    lateinit var objective: String
 //   lateinit var favorite: ListAdapter
 //   lateinit var id : Int
    lateinit var image: String
    lateinit var location: String

    init{
        this.name = name
        this.birthDate = birthDate
        this.weight = weight
        this.height = height
        this.objective = objective
//        this.favorite = favorite
        // this.id = id
        this.image = image
        this.location= location

    }
}