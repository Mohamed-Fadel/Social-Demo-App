package com.example.newsfeedtestapp.remote.mappers.posts

import com.example.newsfeedtestapp.data.models.PostEntity
import com.example.newsfeedtestapp.remote.mappers.EntityMapper
import com.example.newsfeedtestapp.remote.models.posts.PostModel
import javax.inject.Inject

class PostModelEntityMapper @Inject constructor() :
    EntityMapper<PostModel, PostEntity> {
    override fun mapFromModel(model: PostModel): PostEntity =
        PostEntity(
            user_id = model.userId,
            id = model.id,
            title = model.title,
            body = model.body,
        )

}
