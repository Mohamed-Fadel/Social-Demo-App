package com.example.newsfeedtestapp.data.repositories.comments

import com.example.newsfeedtestapp.data.models.CommentEntity
import io.reactivex.Single

interface CommentDataStore {
    fun getComments(postId: Int): Single<List<CommentEntity>>
}