package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectofinal.adapters.LibroSectionAdapter
import com.example.proyectofinal.models.LibroSection
import com.example.proyectofinal.repository.LibroRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var adapterLibroSection: LibroSectionAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dataLibroSectionRepository = LibroRepository()
        var libroSectionArray = dataLibroSectionRepository.getAllLibroSection(this)

        adapterLibroSection = LibroSectionAdapter(this, libroSectionArray)
        list_secciones.adapter = adapterLibroSection

        list_secciones.setOnItemClickListener { adapterView, view, index, l ->

            val intent = Intent(this, Detail_LibroActivity::class.java)
            intent.putExtra("nombre",libroSectionArray.get(index).name)
            intent.putExtra("urlImagelibro",libroSectionArray.get(index).urlImagelibro)
            intent.putExtra("contenido",libroSectionArray.get(index).contenido)


            startActivity(intent)


        }
    }
}