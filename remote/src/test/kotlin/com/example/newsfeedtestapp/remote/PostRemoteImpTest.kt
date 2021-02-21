package com.example.newsfeedtestapp.remote

import com.example.newsfeedtestapp.remote.factory.post.RemotePostFactory
import com.example.newsfeedtestapp.remote.mappers.posts.PostModelEntityMapper
import com.example.newsfeedtestapp.remote.models.posts.PostModel
import com.example.newsfeedtestapp.remote.services.PostsApi
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostRemoteImpTest {
    @Mock
    lateinit var postsApi: PostsApi

    private lateinit var postRemoteInt: PostRemoteImp

    @Before
    fun setUp() {
        postRemoteInt = PostRemoteImp(
            postsApi,
            PostModelEntityMapper()
        )
    }

    @Test
    fun getAllPosts_returnData() {
        // Arrange
        val postList = RemotePostFactory.generateListOfPostModel(6)
        stubPosts(Single.just(postList))

        // Act
        val testObserver = postsApi.getPosts().test()

        // Assert
        testObserver.assertValue(postList)
    }

    @Test
    fun getPost_returnData() {
        // Arrange
        val postId = 1
        val post = RemotePostFactory.generatePostModel()
        stubPost(postId, Single.just(post))

        // Act
        val testObserver = postsApi.getPost(postId).test()

        // Assert
        testObserver.assertValue(post)
    }

    /**
     * Stub helpers
     */

    private fun stubPosts(single: Single<List<PostModel>>) {
        Mockito.`when`(postsApi.getPosts()).thenReturn(
            single
        )
    }

    private fun stubPost(id: Int, single: Single<PostModel>) {
        Mockito.`when`(postsApi.getPost(id)).thenReturn(
            single
        )
    }
}