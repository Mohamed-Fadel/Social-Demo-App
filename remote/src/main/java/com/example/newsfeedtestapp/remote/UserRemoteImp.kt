package com.example.newsfeedtestapp.remote

import com.example.newsfeedtestapp.data.models.UserEntity
import com.example.newsfeedtestapp.data.repositories.users.UserRemote
import com.example.newsfeedtestapp.remote.mappers.users.UserModelEntityMapper
import com.example.newsfeedtestapp.remote.services.UsersApi
import io.reactivex.Single
import javax.inject.Inject

class UserRemoteImp @Inject constructor(
    private val userApi: UsersApi,
    private val userModelEntityMapper: UserModelEntityMapper
) : UserRemote {
    override fun getAllUsers(): Single<List<UserEntity>> {
        return userApi.getAllUsers().map {
            it.map {
                userModelEntityMapper.mapFromModel(it)
            }
        }
    }

    override fun getUser(userId: Int): Single<UserEntity> {
        return userApi.getUser(userId).map {
            userModelEntityMapper.mapFromModel(it)
        }
    }
}