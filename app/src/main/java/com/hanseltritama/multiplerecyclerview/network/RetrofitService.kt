package com.hanseltritama.multiplerecyclerview.network

import com.hanseltritama.multiplerecyclerview.model.Characters
import retrofit2.http.GET

interface RetrofitService {

    @GET("character")
    suspend fun getAllCharacters() : Characters
}