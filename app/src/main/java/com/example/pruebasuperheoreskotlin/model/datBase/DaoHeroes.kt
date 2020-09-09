package com.example.pruebasuperheoreskotlin.model.datBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebasuperheoreskotlin.model.dataClass.DataModelHeroes

@Dao
interface DaoHeroes {
    //Preguntar por que este debe tener onConflict, este sirve para mantener actualizado los nombres
@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertAllHeroes(Heroes:List<DataModelHeroes>)
//cuando agregas livedata no se requiere suspend
@Query("SELECT * FROM tablaHeroes" )
    fun getAllHeroesDB(): LiveData<List<DataModelHeroes>>

}