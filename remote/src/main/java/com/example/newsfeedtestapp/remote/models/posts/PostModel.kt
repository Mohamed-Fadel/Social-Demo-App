package com.example.newsfeedtestapp.remote.models.posts

data class PostModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
