package com.mugerwa.icare

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter( private val products:List<Product>):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.product_row,parent,false)
        val holder=ViewHolder(view)
        view.setOnClickListener {
            val intent= Intent(parent.context,ProductDetails::class.java)
            intent.putExtra("title",products[holder.adapterPosition].title)
            intent.putExtra("image",products[holder.adapterPosition].image)
            intent.putExtra("price",products[holder.adapterPosition].price)
            intent.putExtra("desc",products[holder.adapterPosition].description)
            parent.context.startActivity(intent)
        }

        return  holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product=products[position]
        holder.title.text=product.title
        holder.price.text= product.price.toString()

        Picasso.get().load(product.image).into(holder.image);
    }

    override fun getItemCount(): Int {
        return products.size
    }
    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val title:TextView=itemView.findViewById(R.id.title)
        val price:TextView=itemView.findViewById(R.id.price)
        val image:ImageView=itemView.findViewById(R.id.photo)

    }
}