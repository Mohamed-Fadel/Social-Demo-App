package com.example.newsfeedtestapp.remote

import com.example.newsfeedtestapp.data.models.PostEntity
import com.example.newsfeedtestapp.data.repositories.posts.PostRemote
import com.example.newsfeedtestapp.remote.mappers.posts.PostModelEntityMapper
import com.example.newsfeedtestapp.remote.services.PostsApi
import io.reactivex.Single
import javax.inject.Inject

class PostRemoteImp @Inject constructor(
    private val postsApi: PostsApi,
    private val postModelEntityMapper: PostModelEntityMapper
) : PostRemote {
    override fun getAllPosts(): Single<List<PostEntity>> {
        return postsApi.getPosts().map {
            it.map {
                postModelEntityMapper.mapFromModel(it)
            }
        }
    }

    override fun getPost(postId: Int): Single<PostEntity> {
        return postsApi.getPost(postId).map {
            postModelEntityMapper.mapFromModel(it)
        }
    }
}