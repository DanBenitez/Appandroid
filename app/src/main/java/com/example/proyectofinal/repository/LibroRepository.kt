package com.example.proyectofinal.repository

import android.content.Context
import com.example.proyectofinal.models.LibroSection
import com.example.proyectofinal.utils.readJSON
import org.json.JSONObject

class LibroRepository {

    fun getAllLibroSection(context: Context): ArrayList<LibroSection> {
        val libroSectionObject = JSONObject(readJSON(context, "sectionlibro.json"))
        return parseSectionLibroJsonToResult(libroSectionObject)
    }

    private fun parseSectionLibroJsonToResult(libroSectionObject: JSONObject): ArrayList<LibroSection> {
        val libroSectionJsonArray = libroSectionObject.getJSONArray("sectionlibro")
        val responseLibroSectionList: ArrayList<LibroSection> = ArrayList()

        for (index in 0 until libroSectionJsonArray.length()) {
            val libroSectionObject_ = libroSectionJsonArray[index] as JSONObject
            val id: String = libroSectionObject_.getString("id")
            val name: String = libroSectionObject_.getString("nombre")
            val urlImage: String = libroSectionObject_.getString("urlImage")
            val contenido: String = libroSectionObject_.getString("contenido")
            val urlImagelibro: String = libroSectionObject_.getString("urlImagelibro")


            val libroSection_ = LibroSection(id, name, urlImage, contenido,urlImagelibro)
            responseLibroSectionList.add(libroSection_)
        }
        return responseLibroSectionList
    }

}