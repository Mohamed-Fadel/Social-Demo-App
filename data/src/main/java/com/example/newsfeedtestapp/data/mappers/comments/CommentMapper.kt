package com.example.newsfeedtestapp.data.mappers.comments

import com.example.newsfeedtestapp.data.mappers.Mapper
import com.example.newsfeedtestapp.data.models.CommentEntity
import com.example.newsfeedtestapp.domain.models.comments.Comment
import javax.inject.Inject

class CommentMapper @Inject constructor() :
    Mapper<CommentEntity, Comment> {

    override fun mapFromEntity(type: CommentEntity): Comment {
        return Comment(
            postId = type.postId,
            id = type.id,
            name = type.name,
            email = type.email,
            body = type.body
        )
    }

    override fun mapToEntity(type: Comment): CommentEntity {
        return CommentEntity(
            postId = type.postId,
            id = type.id,
            name = type.name,
            email = type.email,
            body = type.body
        )
    }
}
