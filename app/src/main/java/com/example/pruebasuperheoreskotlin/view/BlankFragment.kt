package com.example.pruebasuperheoreskotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebasuperheoreskotlin.R
import com.example.pruebasuperheoreskotlin.model.dataClass.DataModelHeroes
import com.example.pruebasuperheoreskotlin.viewModel.ViewModelHeroes
import kotlinx.android.synthetic.main.fragment_blank.*


/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {


    //En esta linea instancio el adapter
    private lateinit var heroesAdapter: AdapterHeroes
    //En esta Linea instancio la Lista que contendra al adapter
    private lateinit var mLista: List<DataModelHeroes>
    //declaramos el viewmodel paraa traer los metodos que vienen de viewmodel
    private lateinit var mLVDataHeroes: ViewModelHeroes


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //(main Activity)
        //Iniciar la lista
        mLista=ArrayList()
        //Entregar la lista a la variable de adapters
        //esta es la forma de setear una lista sin livedata a un adapter
        heroesAdapter=AdapterHeroes(mLista)
        // heroesAdapter= AdapterHeroes(mLVDataHeroes.obtenerListaDesdeRepo())
        //enlazar el adapter a la vista recyclerView, la palabra adapter es parte de la formula, layoutManayer igual
        myrecycler.adapter=heroesAdapter
        myrecycler.layoutManager= LinearLayoutManager(context)
        //Aquí se esta instanciando el ViewModel, esta instancia se hace de manera especifica para viewmodel para usar sus poderes
        mLVDataHeroes= ViewModelProvider(this).get(ViewModelHeroes::class.java)
        mLVDataHeroes.puenteentreViewModelYRepo()
        //LiveData agregamos el observer para poder setear la lista en el adpter
        mLVDataHeroes.obtenerListaDesdeRepo().observe(viewLifecycleOwner,{
           heroesAdapter.refreshData(it)
        })



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            BlankFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }


}