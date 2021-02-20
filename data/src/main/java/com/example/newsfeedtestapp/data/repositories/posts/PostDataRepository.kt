package com.example.newsfeedtestapp.data.repositories.posts

import com.example.newsfeedtestapp.data.mappers.posts.PostMapper
import com.example.newsfeedtestapp.data.stores.posts.PostDataStoreFactory
import com.example.newsfeedtestapp.domain.models.posts.Post
import com.example.newsfeedtestapp.domain.repositories.PostRepository
import io.reactivex.Single
import javax.inject.Inject

class PostDataRepository @Inject constructor(
    private val postMapper: PostMapper,
    private val postDataStoreFactory: PostDataStoreFactory
) : PostRepository {
    override fun getAllPosts(): Single<List<Post>> {
        return postDataStoreFactory.getRemoteDataStore().getAllPosts().map {
            it.map {
                postMapper.mapFromEntity(it)
            }
        }
    }

    override fun getPost(postId: Int): Single<Post> {
        return postDataStoreFactory.getRemoteDataStore().getPost(postId).map {
            postMapper.mapFromEntity(it)
        }
    }
}