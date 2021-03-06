package com.example.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import com.example.retrofit2.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        getDataFromApi()
    }

    private fun getDataFromApi(){
        ApiService.endpoint.getPhotos()
            .enqueue(object: Callback<List<MainModel>> {
                override fun onResponse(
                    call: Call<List<MainModel>>,
                    response: Response<List<MainModel>>
                ) {
                    if(response.isSuccessful){
                        val result = response.body()
                        showPhotos(result!!)
                    }
                }

                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                    printLog(t.toString())
                }

            })
    }

    private fun printLog(message: String){
        Log.d(TAG, message)
    }

    private fun showPhotos(photos: List<MainModel>){
        for(photo in photos)
            printLog("url: ${photo.url}")
    }
}