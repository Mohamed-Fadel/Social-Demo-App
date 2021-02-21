package com.example.newsfeedtestapp.data.stores.users

import com.example.newsfeedtestapp.data.factory.post_entity.UserEntityFactory
import com.example.newsfeedtestapp.data.models.UserEntity
import com.example.newsfeedtestapp.data.repositories.users.UserRemote
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRemoteDataStoreTest {
    @Mock
    lateinit var userRemote: UserRemote

    private lateinit var userRemoteDataStore: UserRemoteDataStore

    @Before
    fun setUp() {
        userRemoteDataStore = UserRemoteDataStore(userRemote)
    }

    @Test
    fun getAllUsers() {
        // Arrange
        val userList = UserEntityFactory.generateDummyUsersEntities(5)
        stubUserRemoteGetUsers(Single.just(userList))

        // Act
        val testObserver = userRemoteDataStore.getAllUsers().test()

        // Assert
        testObserver.assertValue(userList)
    }

    @Test
    fun getUser() {
        // Arrange
        val userId = 1
        val user = UserEntityFactory.generateUserEntity()
        stubUserRemoteGetUser(userId, Single.just(user))

        // Act
        val testObserver = userRemoteDataStore.getUser(userId).test()

        // Assert
        testObserver.assertValue(user)
    }

    /**
     * Stub Helper methods
     */
    private fun stubUserRemoteGetUsers(single: Single<List<UserEntity>>) {
        Mockito.`when`(userRemote.getAllUsers())
            .thenReturn(single)
    }

    /**
     * Stub Helper methods
     */
    private fun stubUserRemoteGetUser(id: Int, single: Single<UserEntity>) {
        Mockito.`when`(userRemote.getUser(id))
            .thenReturn(single)
    }
}