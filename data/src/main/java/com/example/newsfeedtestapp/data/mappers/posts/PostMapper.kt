package com.example.newsfeedtestapp.data.mappers.posts

import com.example.newsfeedtestapp.data.mappers.Mapper
import com.example.newsfeedtestapp.data.models.PostEntity
import com.example.newsfeedtestapp.domain.models.posts.Post
import javax.inject.Inject

class PostMapper @Inject constructor() :
    Mapper<PostEntity, Post> {

    override fun mapFromEntity(type: PostEntity): Post {
        return Post(
            user_id = type.user_id,
            id = type.id,
            title = type.title,
            body = type.body
        )
    }

    override fun mapToEntity(type: Post): PostEntity {
        return PostEntity(
            user_id = type.user_id,
            id = type.id,
            title = type.title,
            body = type.body
        )
    }
}
