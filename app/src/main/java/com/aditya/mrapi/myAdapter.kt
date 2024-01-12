package com.aditya.mrapi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class myAdapter(val context: MainActivity, val productList:List<Product>):
    RecyclerView.Adapter<myAdapter.myViewHolder>() {


    inner class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        var title:TextView
        var image:ShapeableImageView
        var price:TextView
        var brand:TextView

        init {
            title=itemView.findViewById(R.id.productTitle)
            image=itemView.findViewById(R.id.productImage)
            price=itemView.findViewById(R.id.productPrice)
            brand=itemView.findViewById(R.id.productBrands)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       return myViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
       )
    }

    override fun getItemCount(): Int {
     return productList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
   val getData=productList[position]
        holder.title.text=getData.title
        holder.brand.text=getData.brand
        holder.price.text= getData.price.toString()
        Picasso.get().load(getData.thumbnail).into(holder.image)

        holder.itemView.setOnClickListener {
            Toast.makeText(context,"Just Clicked ${getData.title}",Toast.LENGTH_SHORT).show()
            val i=Intent(context,MainActivity2::class.java)
            i.putExtra("title",getData.title)
            i.putExtra("url",getData.thumbnail)
            i.putExtra("desc",getData.description)
            context.startActivity(i)
        }

    }


}