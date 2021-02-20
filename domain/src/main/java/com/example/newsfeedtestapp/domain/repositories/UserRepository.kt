package com.example.newsfeedtestapp.domain.repositories

import com.example.newsfeedtestapp.domain.models.users.User
import io.reactivex.Single


interface UserRepository {
    fun getAllUsers(): Single<List<User>>
    fun getUser(userId: Int): Single<User>
}