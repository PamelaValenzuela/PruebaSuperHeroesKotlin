package com.example.pruebasuperheoreskotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pruebasuperheoreskotlin.R
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebasuperheoreskotlin.model.dataClass.DataModelHeroes
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_cardrecycler.view.*

//los dos puntos en esta ocasión de refiere a lo que es, porque esta despues de una variable
class AdapterHeroes (var mDataAdapter: List<DataModelHeroes>): RecyclerView.Adapter<AdapterHeroes.ViewHolderDataModelHeroes>() {
//este método necesita un poco de explicación


    fun  refreshData(mlist: List<DataModelHeroes>){
        mDataAdapter=mlist
        notifyDataSetChanged()

    }
    class ViewHolderDataModelHeroes (itemView: View): RecyclerView.ViewHolder(itemView){
        var mNameHeroes:TextView=itemView.supernombre
        var idHeroes: TextView=itemView.idsuper
        var imagenHeroes: ImageView =itemView.imagesuper

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderDataModelHeroes {
        return ViewHolderDataModelHeroes(LayoutInflater.from(parent.context).inflate(R.layout.layout_cardrecycler,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderDataModelHeroes, position: Int) {
        val mHeroes= mDataAdapter[position]
        holder.idHeroes.text=mHeroes.id.toString()
        holder.mNameHeroes.text=mHeroes.name
// en está línea se utiliza para setear la imagen a la vista, recordar que se debe implementar en el gradle
        //preguntar por Slug
    Picasso.get().load("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/${mHeroes.slug}.jpg").into(holder.imagenHeroes)

    }

    override fun getItemCount(): Int {
        return mDataAdapter.size
    }
}