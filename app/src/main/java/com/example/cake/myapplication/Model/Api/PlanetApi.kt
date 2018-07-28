package com.example.cake.myapplication.Model.Api

import com.google.gson.annotations.SerializedName

data class PlanetApi( @SerializedName("climate")
                   val climate : String?,
                   @SerializedName("diameter")
                   val diameter : Long?,
                   @SerializedName("name")
                   val name : String?,
                   @SerializedName("orbital_period")
                   val orbitalPeriod : Int?,
                   @SerializedName("population")
                   val population : Long,
                   @SerializedName("residents")
                   val residents : Array<ResidentApi>,
                   @SerializedName("rotation_period")
                   val rotationPeriod : Int,
                   @SerializedName("surface_water")
                   val surfaceWater : Int,
                   @SerializedName("terrain")
                   val terrain : String,
                   @SerializedName("url")
                   val url : String
)