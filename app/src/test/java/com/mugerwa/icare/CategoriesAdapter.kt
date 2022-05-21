package com.mugerwa.icare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(private val categories: List<String>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val  view=LayoutInflater.from(parent.context).inflate(R.layout.category_row,parent,false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
     return  categories.size
    }


}
