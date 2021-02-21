package com.example.newsfeedtestapp.data.stores.users

import com.example.newsfeedtestapp.data.repositories.users.UserRemote
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserDataStoreFactoryTest {

    @Mock
    lateinit var userRemote: UserRemote

    private lateinit var userRemoteDataStore: UserRemoteDataStore

    private lateinit var userDataStoreFactory: UserDataStoreFactory

    @Before
    fun setUp() {
        userRemoteDataStore = UserRemoteDataStore(userRemote)
        userDataStoreFactory = UserDataStoreFactory(userRemoteDataStore)
    }

    @Test
    fun userDataStoreFactory_getDataStore_returnRemoteDataStore() {
        // Act
        val userDataStore = userDataStoreFactory.getRemoteDataStore()

        // Assert
        assert(userDataStore is UserRemoteDataStore)
    }
}