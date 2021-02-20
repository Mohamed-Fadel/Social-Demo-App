package com.example.newsfeedtestapp.data.stores.posts

import com.example.newsfeedtestapp.data.repositories.posts.PostDataStore
import javax.inject.Inject

open class PostDataStoreFactory @Inject constructor(
    private val postRemoteDataStore: PostRemoteDataStore
) {

    fun getRemoteDataStore(): PostDataStore {
        return postRemoteDataStore
    }
}
