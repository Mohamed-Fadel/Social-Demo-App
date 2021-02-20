package com.example.newsfeedtestapp.presentation.postlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsfeedtestapp.domain.usecases.GetUsersPostsUseCase
import com.example.newsfeedtestapp.presentation.extensions.map
import com.example.newsfeedtestapp.presentation.extensions.observeDataFrom
import com.example.newsfeedtestapp.presentation.extensions.observeEmptyFrom
import com.example.newsfeedtestapp.presentation.extensions.observeErrorFrom
import com.example.newsfeedtestapp.presentation.postlist.models.PostItem
import com.example.newsfeedtestapp.presentation.postlist.models.PostItemMapper
import com.example.newsfeedtestapp.presentation.result.Event
import com.example.newsfeedtestapp.presentation.result.Result
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel @Inject constructor(
    private val getUsersPostsUseCase: GetUsersPostsUseCase,
    private val mapper: PostItemMapper
) : ViewModel() {

    val loading: LiveData<Boolean>

    val showEmptyView: LiveData<Boolean>

    private val postListResult = MutableLiveData<Result<List<PostItem>>>()

    private val _errorMessage = MediatorLiveData<Event<String>>()
    val errorMessage: LiveData<Event<String>>
        get() = _errorMessage

    private val _postList = MediatorLiveData<List<PostItem>>()
    val postList: LiveData<List<PostItem>>
        get() = _postList

    private val compositeDisposable = CompositeDisposable()

    init {
        loading = postListResult.map {
            it is Result.Loading
        }

        showEmptyView = observeEmptyFrom(postListResult)

        _errorMessage.observeErrorFrom(postListResult)

        _postList.observeDataFrom(postListResult)

        get()
    }

    fun get() =
        compositeDisposable.add(
            getUsersPostsUseCase.get()
                .doOnSubscribe { postListResult.postValue(Result.Loading()) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map { mapper.mapToPresentation(it) }
                .subscribe({
                    postListResult.postValue(Result.Success(it))
                }, {
                    postListResult.postValue(Result.Error(it.localizedMessage))
                })
        )

    fun onRefreshButtonClicked() {
        get()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}