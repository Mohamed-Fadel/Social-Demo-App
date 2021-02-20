package com.example.newsfeedtestapp.domain.models.comments

data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
