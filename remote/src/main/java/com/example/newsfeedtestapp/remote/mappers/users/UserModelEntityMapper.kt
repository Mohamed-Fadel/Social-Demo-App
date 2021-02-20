package com.example.newsfeedtestapp.remote.mappers.users

import com.example.newsfeedtestapp.data.models.UserEntity
import com.example.newsfeedtestapp.remote.mappers.EntityMapper
import com.example.newsfeedtestapp.remote.models.users.UserModel
import javax.inject.Inject

class UserModelEntityMapper @Inject constructor() :
    EntityMapper<UserModel, UserEntity> {
    override fun mapFromModel(model: UserModel): UserEntity =
        UserEntity(
            id = model.id,
            name = model.name,
            username = model.username,
            phone = model.phone,
            email = model.email
        )

}
