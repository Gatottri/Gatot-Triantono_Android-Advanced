package com.example.gatottriantono_androidadvanced

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataClass(var dataImage:Int, var dataTitle:String, var dataDesc : String, var dataDetailImage:Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )


    companion object : Parceler<DataClass> {

        override fun DataClass.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(dataImage)
            parcel.writeString(dataTitle)
            parcel.writeString(dataDesc)
            parcel.writeInt(dataDetailImage)
        }

        override fun create(parcel: Parcel): DataClass {
            return DataClass(parcel)
        }
    }
}
