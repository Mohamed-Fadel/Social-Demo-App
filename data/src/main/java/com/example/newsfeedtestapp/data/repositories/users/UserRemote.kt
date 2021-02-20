package com.example.newsfeedtestapp.data.repositories.users

import com.example.newsfeedtestapp.data.models.UserEntity
import io.reactivex.Single

interface UserRemote {
    fun getAllUsers(): Single<List<UserEntity>>
    fun getUser(userId: Int): Single<UserEntity>
}
