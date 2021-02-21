package com.example.newsfeedtestapp.domain.usecases

import com.example.newsfeedtestapp.domain.factory.generateDummyComments
import com.example.newsfeedtestapp.domain.models.comments.Comment
import com.example.newsfeedtestapp.domain.repositories.CommentRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetPostCommentsUseCaseTest {
    @Mock
    lateinit var commentRepository: CommentRepository

    private lateinit var getPostCommentsUseCase: GetPostCommentsUseCase
    private lateinit var userCommentMapper: UserCommentMapper

    private val postId = "1"

    @Before
    fun setUp() {
        userCommentMapper = UserCommentMapper()
        getPostCommentsUseCase = GetPostCommentsUseCase(
            commentRepository,
            userCommentMapper
        )
    }

    @Test
    fun get() {
        // Arrange
        val commentList = generateDummyComments(5)
        stubComments(postId.toInt(), Single.just(commentList))

        // Act
        val testObserver = getPostCommentsUseCase.get(postId).test()

        testObserver.assertValue(userCommentMapper.map(commentList))
    }

    /**
     * Stub helpers
     */

    private fun stubComments(postId: Int, single: Single<List<Comment>>) {
        Mockito.`when`(commentRepository.getComments(postId)).thenReturn(
            single
        )
    }
}