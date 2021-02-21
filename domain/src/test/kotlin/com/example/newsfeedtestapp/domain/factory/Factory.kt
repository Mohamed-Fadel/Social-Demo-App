package com.example.newsfeedtestapp.domain.factory

import com.example.newsfeedtestapp.domain.models.comments.Comment

fun generateDummyComments(size: Int): List<Comment> {
    val mutableCommentList = mutableListOf<Comment>()
    repeat(size) {
        mutableCommentList.add(generateComment())
    }

    return mutableCommentList
}

fun generateComment(): Comment {
    return Comment(
        postId = DataFactory.getRandomInt(),
        id = DataFactory.getRandomInt(),
        name = DataFactory.getRandomString(),
        email = DataFactory.getRandomString(),
        body = DataFactory.getRandomString()
    )
}