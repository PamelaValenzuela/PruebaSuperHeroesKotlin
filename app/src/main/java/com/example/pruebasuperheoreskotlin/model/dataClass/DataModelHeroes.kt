package com.example.pruebasuperheoreskotlin.model.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablaHeroes")
data class DataModelHeroes (
    @PrimaryKey val id:Int,
                 val name:String,
    //siempre debe ser tal cual llega de la api
                 val slug:String){

}