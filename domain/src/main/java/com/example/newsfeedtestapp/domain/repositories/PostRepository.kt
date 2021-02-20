package com.example.newsfeedtestapp.domain.repositories

import com.example.newsfeedtestapp.domain.models.posts.Post
import io.reactivex.Single


interface PostRepository {
    fun getAllPosts(): Single<List<Post>>

    fun getPost(postId: Int): Single<Post>
}
