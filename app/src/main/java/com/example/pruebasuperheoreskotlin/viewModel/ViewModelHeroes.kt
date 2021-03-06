package com.example.pruebasuperheoreskotlin.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.pruebasuperheoreskotlin.model.RepositorioHeroes
import com.example.pruebasuperheoreskotlin.model.dataClass.DataModelHeroes

//reposotorio necesita un contexto que viene del viewmodel que viene del main

class ViewModelHeroes(application: Application):AndroidViewModel(application){

 private val mRepostorio: RepositorioHeroes= RepositorioHeroes(application)

    fun puenteentreViewModelYRepo(){
        mRepostorio.insertpuenteentreDaoYRepositorio()
    }
    //debe retornar una lista, y entonces además debo agregar return
    fun obtenerListaDesdeRepo(): LiveData<List<DataModelHeroes>>{
        return mRepostorio.obtienelalistaBaseDato()
    }

}