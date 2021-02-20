package com.example.newsfeedtestapp.remote.models.comments

data class CommentModel(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
