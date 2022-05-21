package com.mugerwa.icare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.squareup.picasso.Picasso

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val productname:TextView=findViewById(R.id.productname)
        val productimage:ImageView=findViewById(R.id.productimage)
        val productprice:TextView=findViewById(R.id.productprice)
        val productdesc:TextView=findViewById(R.id.description)
        val availability: Button=findViewById(R.id.avalaibility)


        val title=intent.getStringExtra("title");
        val photoUrl=intent.getStringExtra("image")
        val price=intent.getDoubleExtra("price",0.0)
        val desc=intent.getStringExtra("desc")


        productname.text=title
        productprice.text= price.toString()
        productdesc.text=desc
        Picasso.get().load(photoUrl).into(productimage)

        availability.setOnClickListener {
            AlertDialog.Builder(this)
                        .setMessage("Hey $title is in stock")
                        .setPositiveButton("ok"){p0,p1 ->}
                        .create()
                        .show()
        }
    }
}