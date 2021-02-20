package com.example.newsfeedtestapp.data.stores.users

import com.example.newsfeedtestapp.data.repositories.users.UserDataStore
import javax.inject.Inject

open class UserDataStoreFactory @Inject constructor(
    private val userRemoteDataStore: UserRemoteDataStore
) {

    fun getRemoteDataStore(): UserDataStore {
        return userRemoteDataStore
    }
}
