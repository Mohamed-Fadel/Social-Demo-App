package com.example.newsfeedtestapp.remote.models.posts

data class PostModel(
    val user_id: Int,
    val id: Int,
    val title: String,
    val body: String
)
