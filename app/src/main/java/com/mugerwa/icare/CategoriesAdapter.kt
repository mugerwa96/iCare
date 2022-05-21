package com.mugerwa.icare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CategoriesAdapter(val categories:List<String>):
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.category_row,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        holder.categoryname.text=categories[position]
    }

    override fun getItemCount(): Int {
      return categories.size
    }
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val categoryname:TextView=itemView.findViewById(R.id.categoryname)
    }
}