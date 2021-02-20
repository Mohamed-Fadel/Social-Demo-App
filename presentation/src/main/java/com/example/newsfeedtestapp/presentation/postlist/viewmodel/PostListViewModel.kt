package com.example.newsfeedtestapp.presentation.postlist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newsfeedtestapp.domain.usecases.GetUsersPostsUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel @Inject constructor(
    private val getUsersPostsUseCase: GetUsersPostsUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    init {
        get()
    }

    fun get() =
        compositeDisposable.add(
            getUsersPostsUseCase.get()
//            .doOnSubscribe { posts.postValue(Data(dataState = DataState.LOADING, data = posts.value?.data, message = null)) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
//            .map { mapper.mapToPresentation(it) }
                .subscribe({
                    print("success")
//                posts.postValue(Data(dataState = DataState.SUCCESS, data = it, message = null))
                }, {
                    print("failure")

//                posts.postValue(Data(dataState = DataState.ERROR, data = posts.value?.data, message = it.message))
                })
        )

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}