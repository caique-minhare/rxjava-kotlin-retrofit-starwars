package com.example.cake.myapplication.Model.Api

import com.example.cake.myapplication.Model.Planet
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class StarWarsApi{
    val service : StarWarsInterfaceApi

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co/api")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build()

        service = retrofit.create<StarWarsInterfaceApi>(StarWarsInterfaceApi::class.java)
    }

    fun loadingPlanets() : Observable<Planet>{
        return service.listPlanet()
                      .flatMap { planetResult -> Observable.fromIterable(planetResult.result) }
                      .flatMap{ planet -> Observable.just(Planet(planet.climate, planet.diameter, planet.name, planet.orbitalPeriod,
                                                                 planet.population, planet.rotationPeriod, planet.surfaceWater,
                                                                 planet.terrain, planet.url)) }
    }
}
