package com.bytza.retrofittest02.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bytza.retrofittest02.retrofit.Post
import com.bytza.retrofittest02.retrofit.PostService
import com.bytza.retrofittest02.retrofit.PostsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {
    private val postService: PostService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postService = retrofit.create(PostService::class.java)
    }

    private val postsRepository = PostsRepository(postService)

    var posts: MutableLiveData<List<Post>?> = postsRepository.getAll()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}