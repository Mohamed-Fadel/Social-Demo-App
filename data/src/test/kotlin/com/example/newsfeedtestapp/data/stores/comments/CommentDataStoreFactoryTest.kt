package com.example.newsfeedtestapp.data.stores.comments

import com.example.newsfeedtestapp.data.repositories.comments.CommentRemote
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CommentDataStoreFactoryTest {
    @Mock
    lateinit var commentRemote: CommentRemote

    private lateinit var commentRemoteDataStore: CommentRemoteDataStore

    private lateinit var commentDataStoreFactory: CommentDataStoreFactory

    @Before
    fun setUp() {
        commentRemoteDataStore = CommentRemoteDataStore(commentRemote)
        commentDataStoreFactory = CommentDataStoreFactory(commentRemoteDataStore)
    }

    @Test
    fun commentDataStoreFactory_getDataStore_returnRemoteDataStore() {
        // Act
        val commentDataStore = commentDataStoreFactory.getRemoteDataStore()

        // Assert
        assert(commentDataStore is CommentRemoteDataStore)
    }
}