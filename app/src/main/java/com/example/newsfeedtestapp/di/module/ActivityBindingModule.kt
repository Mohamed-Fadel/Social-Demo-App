package com.example.newsfeedtestapp.di.module

import com.example.newsfeedtestapp.di.scope.ActivityScoped
import com.example.newsfeedtestapp.ui.postlist.PostListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Mohamed Fadel
 * Date: 10/27/2019.
 * email: mohamedfadel91@gmail.com.
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    internal abstract fun postListActivity(): PostListActivity

}