package com.example.pruebasuperheoreskotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebasuperheoreskotlin.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.mifragment,BlankFragment.newInstance(), "Fragmento")
            .commit()

    }
}