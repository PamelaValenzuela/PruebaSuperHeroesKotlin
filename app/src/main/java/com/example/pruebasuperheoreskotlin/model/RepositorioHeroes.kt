package com.example.pruebasuperheoreskotlin.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.pruebasuperheoreskotlin.model.datBase.DBHeroes
import com.example.pruebasuperheoreskotlin.model.datBase.DaoHeroes
import com.example.pruebasuperheoreskotlin.model.dataClass.DataModelHeroes
import com.example.pruebasuperheoreskotlin.model.retrofit.PRetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class RepositorioHeroes(context: Context) {
    //instanciar la base de datos, porque necesitamos traer los métodos del Dao

    private val dbP: DBHeroes= DBHeroes.getDBHeroes(context)
    //instanciar un objeto para obtener los metodos del dao
    private val objetoDaoHeroes: DaoHeroes = dbP.getDataModelHeroesDao()

    // instanciar un objeto retrofit para recibir la lista
    suspend fun getAllHeroesFromApi()=PRetrofitClient.retrofitInstance().getAllHeroesFromApi()
    //suspend quiere decir que hará la ejecución en otro hilo
    //cuando pasamos lo que tenemos getAllHeroes.. es como pasar una lista
    //entonces agregamos corutinas y lanzamiento, el bloque de codigo n el interior puede ser trabajado como fun normal

    fun insertpuenteentreDaoYRepositorio(){
        CoroutineScope(IO).launch {
            objetoDaoHeroes.insertAllHeroes(getAllHeroesFromApi())
        }
    }
    //devuelve una lista livedata
    fun obtienelalistaBaseDato(): LiveData<List<DataModelHeroes>>{
      return  objetoDaoHeroes.getAllHeroesDB()
    }

    //objetivo final traer metodos del DAO
}