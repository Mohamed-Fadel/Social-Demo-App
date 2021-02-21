package com.example.newsfeedtestapp.data.stores.comments

import com.example.newsfeedtestapp.data.factory.post_entity.CommentEntityFactory
import com.example.newsfeedtestapp.data.models.CommentEntity
import com.example.newsfeedtestapp.data.repositories.comments.CommentRemote
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CommentRemoteDataStoreTest {
    @Mock
    lateinit var commentRemote: CommentRemote

    private lateinit var commentRemoteDataStore: CommentRemoteDataStore

    @Before
    fun setUp() {
        commentRemoteDataStore = CommentRemoteDataStore(commentRemote)
    }

    @Test
    fun commentRemoteDataStore_getComment_returnsData() {
        // Arrange
        val postId = 1
        val commentList = CommentEntityFactory.generateDummyCommentsEntities(5)
        stubCommentRemoteGetComments(postId, Single.just(commentList))

        // Act
        val testObserver = commentRemoteDataStore.getComments(postId).test()

        // Assert
        testObserver.assertValue(commentList)
    }

    /**
     * Stub Helper methods
     */
    private fun stubCommentRemoteGetComments(postId: Int, single: Single<List<CommentEntity>>) {
        Mockito.`when`(commentRemote.getComments(postId))
            .thenReturn(single)
    }
}