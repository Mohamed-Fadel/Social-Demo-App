package com.example.newsfeedtestapp.domain.usecases

import com.example.newsfeedtestapp.domain.models.posts.Post
import com.example.newsfeedtestapp.domain.models.users.User
import com.example.newsfeedtestapp.domain.repositories.PostRepository
import com.example.newsfeedtestapp.domain.repositories.UserRepository
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

data class CombinedUserPost(val user: User, val post: Post)

class GetUsersPostsUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
    private val mapper: UserPostMapper

//    ,
//    threadExecutor: ThreadExecutor,
//    postExecutionThread: PostExecutionThread
)
//    : SingleUseCase<Void, List<Post>>(threadExecutor, postExecutionThread) {
{
    fun get(): Single<List<CombinedUserPost>> =
        Single.zip(userRepository.getAllUsers(), postRepository.getAllPosts(),
            BiFunction { userList, postList -> mapper.map(userList, postList) })
}

class GetUserPostDetailsUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
    private val mapper: UserPostMapper
) {

    fun get(userId: Int, postId: Int): Single<CombinedUserPost> =
        Single.zip(userRepository.getUser(userId), postRepository.getPost(postId),
            BiFunction { user, post -> mapper.map(user, post) })
}

/**
 * To obtain the user from a post we need to use the userId from the post to find it in the user list.
 * This is a limitation that comes from the network API and this specific use case requires both posts and users.
 */
class UserPostMapper @Inject constructor() {

    fun map(user: User, post: Post): CombinedUserPost = CombinedUserPost(user, post)

    fun map(userList: List<User>, postList: List<Post>): List<CombinedUserPost> =
        postList.map { post -> CombinedUserPost(userList.first { post.user_id == it.id }, post) }
}