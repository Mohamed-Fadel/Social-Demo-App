package com.example.newsfeedtestapp.presentation.postlist.models

import com.example.newsfeedtestapp.domain.usecases.CombinedUserPost
import java.io.Serializable
import javax.inject.Inject

data class PostItem(
    val postId: String,
    val userId: String,
    val title: String,
    val body: String,
    val name: String,
    val username: String,
    val email: String,
    val avatar: String
) :
    Serializable

class PostItemMapper @Inject constructor() {

    fun mapToPresentation(cup: CombinedUserPost): PostItem = PostItem(
        cup.post.id.toString(),
        cup.user.id.toString(),
        cup.post.title,
        cup.post.body,
        cup.user.name,
        cup.user.username,
        cup.user.email,
        cup.user.avatar
    )

    fun mapToPresentation(combinedUserPostList: List<CombinedUserPost>): List<PostItem> =
        combinedUserPostList.map { mapToPresentation(it) }
}