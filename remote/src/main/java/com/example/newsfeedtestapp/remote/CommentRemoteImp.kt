package com.example.newsfeedtestapp.remote

import com.example.newsfeedtestapp.data.models.CommentEntity
import com.example.newsfeedtestapp.data.repositories.comments.CommentRemote
import com.example.newsfeedtestapp.remote.mappers.comments.CommentModelEntityMapper
import com.example.newsfeedtestapp.remote.services.CommentsApi
import io.reactivex.Single
import javax.inject.Inject

class CommentRemoteImp @Inject constructor(
    private val commentsApi: CommentsApi,
    private val commentModelEntityMapper: CommentModelEntityMapper
) : CommentRemote {
    override fun getComments(postId: Int): Single<List<CommentEntity>> {
        return commentsApi.getComments(postId).map {
            it.map {
                commentModelEntityMapper.mapFromModel(it)
            }
        }
    }
}