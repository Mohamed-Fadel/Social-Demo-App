package com.example.newsfeedtestapp.presentation.postlist.models

import com.example.newsfeedtestapp.domain.usecases.UserComment
import java.io.Serializable
import javax.inject.Inject

data class CommentItem(
    val commentId: String,
    val postId: String,
    val name: String,
    val email: String,
    val body: String,
    val avatar: String
) :
    Serializable

class CommentItemMapper @Inject constructor() {

    fun mapToPresentation(cup: UserComment): CommentItem = CommentItem(
        postId = cup.comment.postId.toString(),
        commentId = cup.comment.id.toString(),
        name = cup.comment.name,
        email = cup.comment.email,
        body = cup.comment.body,
        avatar = cup.avatar
    )

    fun mapToPresentation(commentList: List<UserComment>): List<CommentItem> =
        commentList.map { mapToPresentation(it) }
}