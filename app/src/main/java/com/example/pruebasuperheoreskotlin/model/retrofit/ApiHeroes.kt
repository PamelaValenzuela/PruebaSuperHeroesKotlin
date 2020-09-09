package com.example.pruebasuperheoreskotlin.model.retrofit

import com.example.pruebasuperheoreskotlin.model.dataClass.DataModelHeroes
import retrofit2.http.GET


interface ApiHeroes {

    @GET("all.json")
        suspend fun getAllHeroesFromApi():List<DataModelHeroes>
}



