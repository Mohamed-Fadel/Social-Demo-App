package com.example.newsfeedtestapp.data.factory.post_entity

import com.example.newsfeedtestapp.data.factory.DataFactory
import com.example.newsfeedtestapp.data.models.PostEntity
import com.example.newsfeedtestapp.domain.models.posts.Post

object PostEntityFactory {
    fun generateDummyPostsEntities(size: Int): List<PostEntity> {
        val mutablePostEntityList = mutableListOf<PostEntity>()
        repeat(size) {
            mutablePostEntityList.add(generatePostEntity())
        }

        return mutablePostEntityList
    }

    fun generatePost(): Post {
        return Post(
            id = DataFactory.getRandomInt(),
            user_id = DataFactory.getRandomInt(),
            title = DataFactory.getRandomString(),
            body = DataFactory.getRandomString()
        )
    }

    fun generatePostEntity(): PostEntity {
        return PostEntity(
            id = DataFactory.getRandomInt(),
            user_id = DataFactory.getRandomInt(),
            title = DataFactory.getRandomString(),
            body = DataFactory.getRandomString()
        )
    }
}