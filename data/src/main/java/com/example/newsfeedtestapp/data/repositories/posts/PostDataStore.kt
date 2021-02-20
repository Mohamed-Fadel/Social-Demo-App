package com.example.newsfeedtestapp.data.repositories.posts

import com.example.newsfeedtestapp.data.models.PostEntity
import io.reactivex.Single

interface PostDataStore {
    fun getAllPosts(): Single<List<PostEntity>>
    fun getPost(postId: Int): Single<PostEntity>
}