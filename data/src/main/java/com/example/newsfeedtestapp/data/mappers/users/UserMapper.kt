package com.example.newsfeedtestapp.data.mappers.users

import com.example.newsfeedtestapp.data.mappers.Mapper
import com.example.newsfeedtestapp.data.models.UserEntity
import com.example.newsfeedtestapp.domain.models.users.User
import javax.inject.Inject

class UserMapper @Inject constructor() :
    Mapper<UserEntity, User> {

    override fun mapFromEntity(type: UserEntity): User {
        return User(
            id = type.id,
            name = type.name,
            username = type.username,
            phone = type.phone,
            email = type.email,
            avatar = "https://i.pravatar.cc/150?u=${type.email}"
        )
    }

    override fun mapToEntity(type: User): UserEntity {
        return UserEntity(
            id = type.id,
            name = type.name,
            username = type.username,
            phone = type.phone,
            email = type.email
        )
    }
}
