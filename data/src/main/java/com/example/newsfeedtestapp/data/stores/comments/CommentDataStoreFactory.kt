package com.example.newsfeedtestapp.data.stores.comments

import com.example.newsfeedtestapp.data.repositories.comments.CommentDataStore
import javax.inject.Inject

open class CommentDataStoreFactory @Inject constructor(
    private val commentRemoteDataStore: CommentRemoteDataStore
) {

    fun getRemoteDataStore(): CommentDataStore {
        return commentRemoteDataStore
    }
}
