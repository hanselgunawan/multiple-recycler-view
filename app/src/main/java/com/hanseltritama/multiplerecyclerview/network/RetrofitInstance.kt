package com.hanseltritama.multiplerecyclerview.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val retrofit: Retrofit =
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val rickMortyAPI = retrofit.create(RetrofitService::class.java)

    fun getMortyAPI(): RetrofitService? {
        return rickMortyAPI
    }
}