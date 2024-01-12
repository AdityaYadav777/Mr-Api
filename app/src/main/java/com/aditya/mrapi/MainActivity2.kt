package com.aditya.mrapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditya.mrapi.databinding.ActivityMain2Binding
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val url=intent.getStringExtra("url")
        val title=intent.getStringExtra("title")
        val desc=intent.getStringExtra("desc")

        Picasso.get().load(url).into(binding.showImage)
        binding.showTitle.text=title
        binding.showDesc.text=desc

    }
}