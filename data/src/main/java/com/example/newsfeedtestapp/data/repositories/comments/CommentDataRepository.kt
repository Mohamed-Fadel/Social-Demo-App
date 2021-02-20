package com.example.newsfeedtestapp.data.repositories.comments

import com.example.newsfeedtestapp.data.mappers.comments.CommentMapper
import com.example.newsfeedtestapp.data.stores.comments.CommentDataStoreFactory
import com.example.newsfeedtestapp.domain.models.comments.Comment
import com.example.newsfeedtestapp.domain.repositories.CommentRepository
import io.reactivex.Single
import javax.inject.Inject

class CommentDataRepository @Inject constructor(
    private val commentMapper: CommentMapper,
    private val commentDataStoreFactory: CommentDataStoreFactory
) : CommentRepository {
    override fun getComments(postId: Int): Single<List<Comment>> {
        return commentDataStoreFactory.getRemoteDataStore().getComments(postId).map {
            it.map {
                commentMapper.mapFromEntity(it)
            }
        }
    }
}