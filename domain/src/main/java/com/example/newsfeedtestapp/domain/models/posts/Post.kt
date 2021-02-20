package com.example.newsfeedtestapp.domain.models.posts

data class Post(
    val user_id: Int,
    val id: Int,
    val title: String,
    val body: String
)
