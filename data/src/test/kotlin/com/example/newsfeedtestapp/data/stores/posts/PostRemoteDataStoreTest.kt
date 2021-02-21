package com.example.newsfeedtestapp.data.stores.posts

import com.example.newsfeedtestapp.data.factory.DataFactory
import com.example.newsfeedtestapp.data.factory.post_entity.PostEntityFactory
import com.example.newsfeedtestapp.data.models.PostEntity
import com.example.newsfeedtestapp.data.repositories.posts.PostRemote
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostRemoteDataStoreTest {
    @Mock
    lateinit var postRemote: PostRemote

    private lateinit var postRemoteDataStore: PostRemoteDataStore

    @Before
    fun setup() {
        postRemoteDataStore = PostRemoteDataStore(postRemote)
    }

    @Test
    fun postRemoteDataStore_getAllPosts_returnsData() {
        // Arrange
        val postList = PostEntityFactory.generateDummyPostsEntities(5)
        stubPostRemoteGetAllPosts(Single.just(postList))

        // Act
        val testObserver = postRemoteDataStore.getAllPosts().test()

        // Assert
        testObserver.assertValue(postList)
    }

    @Test
    fun postRemoteDataStore_getPost_returnsData() {

        val id = DataFactory.getRandomInt()
        // Arrange
        val post = PostEntityFactory.generatePostEntity()
        stubPostRemoteGetPost(id, Single.just(post))

        // Act
        val testObserver = postRemoteDataStore.getPost(id).test()

        // Assert
        testObserver.assertValue(post)
    }


    /**
     * Stub Helper methods
     */
    private fun stubPostRemoteGetAllPosts(single: Single<List<PostEntity>>) {
        Mockito.`when`(postRemote.getAllPosts())
            .thenReturn(single)
    }

    /**
     * Stub Helper methods
     */
    private fun stubPostRemoteGetPost(id: Int, single: Single<PostEntity>) {
        Mockito.`when`(postRemote.getPost(id))
            .thenReturn(single)
    }
}