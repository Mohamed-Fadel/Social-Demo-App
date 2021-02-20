package com.example.newsfeedtestapp.data.repositories.users

import com.example.newsfeedtestapp.data.mappers.users.UserMapper
import com.example.newsfeedtestapp.data.stores.users.UserDataStoreFactory
import com.example.newsfeedtestapp.domain.models.users.User
import com.example.newsfeedtestapp.domain.repositories.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val userMapper: UserMapper,
    private val userDataStoreFactory: UserDataStoreFactory
) : UserRepository {
    override fun getAllUsers(): Single<List<User>> {
        return userDataStoreFactory.getRemoteDataStore().getAllUsers().map {
            it.map {
                userMapper.mapFromEntity(it)
            }
        }
    }

    override fun getUser(userId: Int): Single<User> {
        return userDataStoreFactory.getRemoteDataStore().getUser(userId).map {
            userMapper.mapFromEntity(it)
        }
    }
}