package com.example.pruebasuperheoreskotlin.model.datBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pruebasuperheoreskotlin.model.dataClass.DataModelHeroes
import java.security.AccessControlContext

@Database(entities = [(DataModelHeroes::class)], version = 1)
abstract class DBHeroes:RoomDatabase() {

    abstract fun getDataModelHeroesDao():DaoHeroes



//Esta linea de codigo indica que es und metodo estatico que se realiza sólo una vez
    companion object{

    //no entiendo por que se debe ocupar volatile
    @Volatile
    private var INSTANCE: DBHeroes?= null

    fun getDBHeroes(context: Context):DBHeroes{
        val createdInstance= INSTANCE
        if (createdInstance!=null){
            return createdInstance
        }
        synchronized(this){
            val newInstance= Room.databaseBuilder(context.applicationContext, DBHeroes::class.java, "heroes_db")
             .build()
                INSTANCE= newInstance
                 return newInstance
        }

    }

    }
}