package com.example.newsfeedtestapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsfeedtestapp.di.AppViewModelFactory
import com.example.newsfeedtestapp.di.ViewModelKey
import com.example.newsfeedtestapp.presentation.postlist.viewmodel.PostListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Module used to define the connection between the framework's [ViewModelProvider.Factory] and
 * our own implementation: [AppViewModelFactory].
 */
@Module
@Suppress("UNUSED")
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory):
            ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel::class)
    internal abstract fun postListViewModel(viewModel: PostListViewModel): ViewModel

}
