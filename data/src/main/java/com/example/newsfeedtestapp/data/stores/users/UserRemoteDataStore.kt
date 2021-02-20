package com.example.newsfeedtestapp.data.stores.users

import com.example.newsfeedtestapp.data.models.UserEntity
import com.example.newsfeedtestapp.data.repositories.users.UserDataStore
import com.example.newsfeedtestapp.data.repositories.users.UserRemote
import io.reactivex.Single
import javax.inject.Inject

class UserRemoteDataStore @Inject constructor(
    private val userRemote: UserRemote
) : UserDataStore {
    override fun getAllUsers(): Single<List<UserEntity>> {
        return userRemote.getAllUsers()
    }

    override fun getUser(userId: Int): Single<UserEntity> {
        return userRemote.getUser(userId)
    }
}