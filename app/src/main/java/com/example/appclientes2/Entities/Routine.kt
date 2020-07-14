package com.example.appclientes2.Entities

import android.os.Parcel
import android.os.Parcelable

class Routine(var id: Int, var name: String, var imageUrl: String, var bodyPart: String, var duration: String, var level: String, var professor: String, var exercisesList: ArrayList<Exercise> //, intensity : String?
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (other is Routine) {
            return this.id == (other).id
        } else return false
    }

    override fun hashCode(): Int {
        val prime = 17
        return id * prime
    }

    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        ArrayList<Exercise>().apply { source.readList(this as List<*>, Exercise::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(imageUrl)
        writeString(bodyPart)
        writeString(duration)
        writeString(level)
        writeString(professor)
        writeList(exercisesList as List<*>?)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Routine> = object : Parcelable.Creator<Routine> {
            override fun createFromParcel(source: Parcel): Routine = Routine(source)
            override fun newArray(size: Int): Array<Routine?> = arrayOfNulls(size)
        }
    }
}