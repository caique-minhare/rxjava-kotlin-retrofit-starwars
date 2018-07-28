package com.example.cake.myapplication.Model.Api

import io.reactivex.Observable
import retrofit2.http.GET

interface StarWarsInterfaceApi{
    @GET("/planets/")
    fun listPlanet() : Observable<PlanetResultApi>

}