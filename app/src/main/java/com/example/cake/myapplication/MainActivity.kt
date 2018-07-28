package com.example.cake.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.cake.myapplication.Model.Api.PlanetApi
import com.example.cake.myapplication.Model.Api.StarWarsApi
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    var listView : ListView? = null
    var planets = MutableList<String>()
    var planetsAdapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listView = ListView(this)
        setContentView(listView)
        planetsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, planets)
        listView?.adapter = planetsAdapter

        val api = StarWarsApi()
        api.loadingPlanets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    planet -> planets.add("${planet.climate} - ${planet.name}")
                },{
                    e -> e.printStackTrace()
                },{
                    planetsAdapter?.notifyDataSetChanged()
                })
    }
}
