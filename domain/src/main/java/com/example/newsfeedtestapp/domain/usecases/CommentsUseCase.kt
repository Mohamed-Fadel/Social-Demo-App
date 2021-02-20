package com.example.newsfeedtestapp.domain.usecases

import com.example.newsfeedtestapp.domain.models.comments.Comment
import com.example.newsfeedtestapp.domain.repositories.CommentRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCommentListUseCase @Inject constructor(private val repository: CommentRepository) {

    fun get(postId: Int): Single<List<Comment>> = repository.getComments(postId)
}
