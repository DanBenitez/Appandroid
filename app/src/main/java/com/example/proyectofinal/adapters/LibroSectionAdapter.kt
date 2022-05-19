package com.example.proyectofinal.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.proyectofinal.R
import com.example.proyectofinal.models.LibroSection
import kotlinx.android.synthetic.main.activity_item.view.*

class LibroSectionAdapter (private val context: Context, private val libroSectionList: ArrayList<LibroSection>):BaseAdapter(){

    override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {
        val sectionlibro_itemObject=this.libroSectionList[position]
        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val sectionlibroView:View = inflator.inflate(R.layout.activity_item, null)
        sectionlibroView.tv_name_item.text = sectionlibro_itemObject.name

        Glide.with(context).load(sectionlibro_itemObject.urlImage).into(sectionlibroView.imgrequisito)

        return sectionlibroView
    }
    override fun getCount(): Int {
        return libroSectionList.size
    }

    override fun getItem(position: Int): Any {
        return libroSectionList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}