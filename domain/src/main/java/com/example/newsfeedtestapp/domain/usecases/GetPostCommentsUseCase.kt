package com.example.newsfeedtestapp.domain.usecases

import com.example.newsfeedtestapp.domain.models.comments.Comment
import com.example.newsfeedtestapp.domain.repositories.CommentRepository
import io.reactivex.Single
import javax.inject.Inject

data class UserComment(val comment: Comment, val avatar: String)

class GetPostCommentsUseCase @Inject constructor(
    private val commentRepository: CommentRepository,
    private val userCommentMapper: UserCommentMapper
) {
    fun get(postId: String): Single<List<UserComment>> =
        commentRepository.getComments(postId.toInt()).map {
            userCommentMapper.map(it)
        }
}


/**
 * To obtain the user from a post we need to use the userId from the post to find it in the user list.
 * This is a limitation that comes from the network API and this specific use case requires both posts and users.
 */
class UserCommentMapper @Inject constructor() {

    fun map(comment: Comment): UserComment =
        UserComment(comment, "https://i.pravatar.cc/150?u=${comment.email}")

    fun map(commentList: List<Comment>): List<UserComment> =
        commentList.map { comment -> map(comment) }
}