package com.example.newsfeedtestapp.data.stores.posts

import com.example.newsfeedtestapp.data.repositories.posts.PostRemote
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostDataStoreFactoryTest {

    @Mock
    lateinit var postRemote: PostRemote

    private lateinit var postRemoteDataStore: PostRemoteDataStore

    private lateinit var postDataStoreFactory: PostDataStoreFactory

    @Before
    fun setUp() {
        postRemoteDataStore = PostRemoteDataStore(postRemote)
        postDataStoreFactory =
            PostDataStoreFactory(postRemoteDataStore)
    }

    @Test
    fun postDataStoreFactory_getDataStore_returnRemoteDataStore() {
        // Act
        val postDataStore = postDataStoreFactory.getRemoteDataStore()

        // Assert
        assert(postDataStore is PostRemoteDataStore)
    }
}