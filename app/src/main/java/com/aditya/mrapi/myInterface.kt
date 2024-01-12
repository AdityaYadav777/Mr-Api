package com.aditya.mrapi

import retrofit2.Call
import retrofit2.http.GET

interface myInterface {
    @GET("products")
    fun getProductData(): Call<myData>

}