package com.example.newsfeedtestapp.data.stores.comments

import com.example.newsfeedtestapp.data.models.CommentEntity
import com.example.newsfeedtestapp.data.repositories.comments.CommentDataStore
import com.example.newsfeedtestapp.data.repositories.comments.CommentRemote
import io.reactivex.Single
import javax.inject.Inject

class CommentRemoteDataStore @Inject constructor(
    private val commentRemote: CommentRemote
) : CommentDataStore {
    override fun getComments(postId: Int): Single<List<CommentEntity>> {
        return commentRemote.getComments(postId)
    }
}