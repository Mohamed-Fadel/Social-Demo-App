package com.example.newsfeedtestapp.data.stores.posts

import com.example.newsfeedtestapp.data.models.PostEntity
import com.example.newsfeedtestapp.data.repositories.posts.PostDataStore
import com.example.newsfeedtestapp.data.repositories.posts.PostRemote
import io.reactivex.Single
import javax.inject.Inject

class PostRemoteDataStore @Inject constructor(
    private val postRemote: PostRemote
) : PostDataStore {
    override fun getAllPosts(): Single<List<PostEntity>> {
        return postRemote.getAllPosts()
    }

    override fun getPost(postId: Int): Single<PostEntity> {
        return postRemote.getPost(postId)
    }
}