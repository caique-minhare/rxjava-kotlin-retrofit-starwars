package com.example.cake.myapplication.Model.Api

import retrofit2.Retrofit


class StarWarsApi{
    val service : StarWarsInterfaceApi

    init {
        val retrofit = Retrofit.Builder()
                . baseUrl("https://swapi.co/api")
                .addCallAdapterFactory(RxJ)
    }
}