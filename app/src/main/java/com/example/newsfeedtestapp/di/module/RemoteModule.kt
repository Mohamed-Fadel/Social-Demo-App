package com.example.newsfeedtestapp.di.module

import com.example.newsfeedtestapp.data.repositories.comments.CommentRemote
import com.example.newsfeedtestapp.data.repositories.posts.PostRemote
import com.example.newsfeedtestapp.data.repositories.users.UserRemote
import com.example.newsfeedtestapp.remote.CommentRemoteImp
import com.example.newsfeedtestapp.remote.PostRemoteImp
import com.example.newsfeedtestapp.remote.UserRemoteImp
import com.example.newsfeedtestapp.remote.services.CommentsApi
import com.example.newsfeedtestapp.remote.services.PostsApi
import com.example.newsfeedtestapp.remote.services.UsersApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RemoteModule {

    @Provides
    fun providePostRemote(postRemoteImp: PostRemoteImp): PostRemote {
        return postRemoteImp
    }

    @Provides
    fun provideUserRemote(userRemoteImp: UserRemoteImp): UserRemote {
        return userRemoteImp
    }

    @Provides
    fun provideCommentRemote(commentRemoteImp: CommentRemoteImp): CommentRemote {
        return commentRemoteImp
    }

    @Provides
    fun providePostsApi(retrofit: Retrofit): PostsApi = retrofit.create(PostsApi::class.java)

    @Provides
    fun provideUsersApi(retrofit: Retrofit): UsersApi = retrofit.create(UsersApi::class.java)

    @Provides
    fun provideCommentsApi(retrofit: Retrofit): CommentsApi =
        retrofit.create(CommentsApi::class.java)
}