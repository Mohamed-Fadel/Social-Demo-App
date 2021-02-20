package com.example.newsfeedtestapp.remote.mappers.comments

import com.example.newsfeedtestapp.data.models.CommentEntity
import com.example.newsfeedtestapp.remote.mappers.EntityMapper
import com.example.newsfeedtestapp.remote.models.comments.CommentModel
import javax.inject.Inject

class CommentModelEntityMapper @Inject constructor() :
    EntityMapper<CommentModel, CommentEntity> {
    override fun mapFromModel(model: CommentModel): CommentEntity =
        CommentEntity(
            postId = model.postId,
            id = model.id,
            name = model.name,
            email = model.email,
            body = model.body
        )

}
