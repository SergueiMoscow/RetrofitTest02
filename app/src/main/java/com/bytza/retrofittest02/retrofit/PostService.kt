package com.bytza.retrofittest02.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts/")
    fun getAll(): Call<List<Post>>
}