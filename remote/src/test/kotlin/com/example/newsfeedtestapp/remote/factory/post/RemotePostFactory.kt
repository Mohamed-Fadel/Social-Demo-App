package com.example.newsfeedtestapp.remote.factory.post

import com.example.newsfeedtestapp.data.models.PostEntity
import com.example.newsfeedtestapp.remote.factory.DataFactory
import com.example.newsfeedtestapp.remote.models.posts.PostModel

object RemotePostFactory {

    fun generateListOfPostModel(size: Int): MutableList<PostModel> {
        val listOfPostModels = mutableListOf<PostModel>()
        repeat(size) {
            listOfPostModels.add(generatePostModel())
        }
        return listOfPostModels
    }

    fun generatePostModel(): PostModel {
        return PostModel(
            userId = DataFactory.getRandomInt(),
            id = DataFactory.getRandomInt(),
            title = DataFactory.getRandomString(),
            body = DataFactory.getRandomString()
        )
    }

    fun generatePostEntity(): PostEntity {
        return PostEntity(
            user_id = DataFactory.getRandomInt(),
            id = DataFactory.getRandomInt(),
            title = DataFactory.getRandomString(),
            body = DataFactory.getRandomString()
        )
    }
}
