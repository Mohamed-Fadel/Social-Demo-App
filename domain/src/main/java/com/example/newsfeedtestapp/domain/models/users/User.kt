package com.example.newsfeedtestapp.domain.models.users

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val phone: String,
    val email: String,
    val avatar: String
)
