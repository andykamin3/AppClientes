package com.example.appclientes2.Entities

class Event(name : String, hour: Int, day : String, description : String) {

    lateinit var name: String
    var hour: Int
    lateinit var day: String
    lateinit var description: String

    init{
        this.name = name
        this.hour = hour
        this.day = day
        this.description = description
    }
}