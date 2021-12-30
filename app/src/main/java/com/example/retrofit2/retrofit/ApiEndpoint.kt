package com.example.retrofit2.retrofit

import com.example.retrofit2.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("photos")
    fun getPhotos(): Call<List<MainModel>>
}