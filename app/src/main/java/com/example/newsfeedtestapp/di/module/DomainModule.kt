package com.example.newsfeedtestapp.di.module

import com.example.newsfeedtestapp.data.repositories.comments.CommentDataRepository
import com.example.newsfeedtestapp.data.repositories.posts.PostDataRepository
import com.example.newsfeedtestapp.data.repositories.users.UserDataRepository
import com.example.newsfeedtestapp.domain.repositories.CommentRepository
import com.example.newsfeedtestapp.domain.repositories.PostRepository
import com.example.newsfeedtestapp.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providePostRepository(postDataRepository: PostDataRepository): PostRepository {
        return postDataRepository
    }

    @Provides
    fun provideUserRepository(userDataRepository: UserDataRepository): UserRepository {
        return userDataRepository
    }

    @Provides
    fun provideCommentRepository(commentDataRepository: CommentDataRepository): CommentRepository {
        return commentDataRepository
    }

}