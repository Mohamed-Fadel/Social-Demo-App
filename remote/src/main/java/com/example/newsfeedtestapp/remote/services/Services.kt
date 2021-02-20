package com.example.newsfeedtestapp.remote.services

import com.example.newsfeedtestapp.remote.models.comments.CommentModel
import com.example.newsfeedtestapp.remote.models.posts.PostModel
import com.example.newsfeedtestapp.remote.models.users.UserModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostsApi {

    @GET("posts/")
    fun getPosts(): Single<List<PostModel>>

    @GET("posts/{id}")
    fun getPost(@Path("id") postId: Int): Single<PostModel>
}

interface UsersApi {

    @GET("users/")
    fun getAllUsers(): Single<List<UserModel>>

    @GET("users/{id}")
    fun getUser(@Path("id") userId: Int): Single<UserModel>
}

interface CommentsApi {

    @GET("comments/")
    fun getComments(@Query("postId") postId: Int): Single<List<CommentModel>>
}
