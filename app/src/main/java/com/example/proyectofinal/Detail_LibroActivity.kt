package com.example.proyectofinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.proyectofinal.utils.showImageWhitProgresBar
import kotlinx.android.synthetic.main.activity_detail_libro.*


class Detail_LibroActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_libro)



        val bundle = intent.extras
        val nombreLibro = bundle?.get("nombre").toString()
        val contenido = bundle?.get("contenido").toString()
        val urlImagelibro = bundle?.get("urlImagelibro").toString()





        contenidocuadernillo.text= contenido
        titulo.text = nombreLibro


        Glide.with(this).load(urlImagelibro).into(foto)






    }

}