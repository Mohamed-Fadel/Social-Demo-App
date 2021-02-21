package com.example.newsfeedtestapp.data.factory.post_entity

import com.example.newsfeedtestapp.data.factory.DataFactory
import com.example.newsfeedtestapp.data.models.UserEntity

object UserEntityFactory {
    fun generateDummyUsersEntities(size: Int): List<UserEntity> {
        val mutableUserEntityList = mutableListOf<UserEntity>()
        repeat(size) {
            mutableUserEntityList.add(generateUserEntity())
        }

        return mutableUserEntityList
    }

    fun generateUserEntity(): UserEntity {
        return UserEntity(
            id = DataFactory.getRandomInt(),
            name = DataFactory.getRandomString(),
            username = DataFactory.getRandomString(),
            phone = DataFactory.getRandomString(),
            email = DataFactory.getRandomString(),
        )
    }
}