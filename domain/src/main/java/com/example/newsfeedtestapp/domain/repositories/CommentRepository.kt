package com.example.newsfeedtestapp.domain.repositories

import com.example.newsfeedtestapp.domain.models.comments.Comment
import io.reactivex.Single


interface CommentRepository {
    fun getComments(postId: Int): Single<List<Comment>>
}
