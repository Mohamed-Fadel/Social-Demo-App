package com.example.newsfeedtestapp.data.mappers.posts

import com.example.newsfeedtestapp.data.factory.post_entity.PostEntityFactory
import com.example.newsfeedtestapp.data.models.PostEntity
import com.example.newsfeedtestapp.domain.models.posts.Post
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PostMapperTest {
    private lateinit var postMapper: PostMapper

    @Before
    fun setUp() {
        postMapper = PostMapper()
    }

    @Test
    fun mapFromEntity() {
        // Arrange
        val postEntity = PostEntityFactory.generatePostEntity()

        // Act
        val post = postMapper.mapFromEntity(postEntity)

        // Assert
        assertPostDataEquality(postEntity, post)
    }

    @Test
    fun mapToEntity() {
        // Arrange
        val post = PostEntityFactory.generatePost()

        // Act
        val postEntity = postMapper.mapToEntity(post)

        // Assert
        assertPostDataEquality(postEntity, post)
    }

    /**
     * Helper Methods
     */
    private fun assertPostDataEquality(postEntity: PostEntity, post: Post) {
        assertEquals(postEntity.user_id, post.user_id)
        assertEquals(postEntity.id, post.id)
        assertEquals(postEntity.title, post.title)
        assertEquals(postEntity.body, post.body)
    }
}