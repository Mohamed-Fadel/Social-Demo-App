package com.example.newsfeedtestapp.data.factory.post_entity

import com.example.newsfeedtestapp.data.factory.DataFactory
import com.example.newsfeedtestapp.data.models.CommentEntity

object CommentEntityFactory {
    fun generateDummyCommentsEntities(size: Int): List<CommentEntity> {
        val mutableCommentEntityList = mutableListOf<CommentEntity>()
        repeat(size) {
            mutableCommentEntityList.add(generateCommentEntity())
        }

        return mutableCommentEntityList
    }

    fun generateCommentEntity(): CommentEntity {
        return CommentEntity(
            postId = DataFactory.getRandomInt(),
            id = DataFactory.getRandomInt(),
            name = DataFactory.getRandomString(),
            email = DataFactory.getRandomString(),
            body = DataFactory.getRandomString()
        )
    }
}