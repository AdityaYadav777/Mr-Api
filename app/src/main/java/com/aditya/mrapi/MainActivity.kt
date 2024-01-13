package com.aditya.mrapi
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.mrapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val retrofitBuilder=Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(myInterface::class.java)

        val retrofitData=retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<myData?> { //ctrl+shift+space
            override fun onResponse(call: Call<myData?>, response: Response<myData?>) {
                binding.progressBar.visibility=View.GONE
                var responceBody=response.body()
                val productList=responceBody?.products

                binding.myRec.adapter=myAdapter(this@MainActivity,productList!!)
                binding.myRec.layoutManager=LinearLayoutManager(this@MainActivity)



            }
            override fun onFailure(call: Call<myData?>, t: Throwable) {
                Log.d("MAin Activty","faild" + t.message)

            }
        })
    }
}