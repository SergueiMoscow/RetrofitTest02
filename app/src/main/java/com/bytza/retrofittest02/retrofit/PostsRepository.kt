package com.bytza.retrofittest02.retrofit

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsRepository(private val postService: PostService) {

    private var posts: MutableLiveData<List<Post>?> = MutableLiveData()


    fun getAll(): MutableLiveData<List<Post>?> {
        postService.getAll().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val result = response.body()
                if (result != null){
                    posts.value = result
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                var error= t.message
            }
        })

        return posts
    }

}