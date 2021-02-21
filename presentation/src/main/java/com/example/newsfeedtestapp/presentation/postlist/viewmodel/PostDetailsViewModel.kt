package com.example.newsfeedtestapp.presentation.postlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsfeedtestapp.domain.usecases.GetPostCommentsUseCase
import com.example.newsfeedtestapp.domain.usecases.GetUserPostUseCase
import com.example.newsfeedtestapp.presentation.extensions.observeDataFrom
import com.example.newsfeedtestapp.presentation.extensions.observeEmptyFrom
import com.example.newsfeedtestapp.presentation.extensions.observeErrorFrom
import com.example.newsfeedtestapp.presentation.postlist.models.CommentItem
import com.example.newsfeedtestapp.presentation.postlist.models.CommentItemMapper
import com.example.newsfeedtestapp.presentation.postlist.models.PostItem
import com.example.newsfeedtestapp.presentation.postlist.models.PostItemMapper
import com.example.newsfeedtestapp.presentation.result.Event
import com.example.newsfeedtestapp.presentation.result.Result
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostDetailsViewModel @Inject constructor(
    private val getUserPostUseCase: GetUserPostUseCase,
    private val getPostCommentsUseCase: GetPostCommentsUseCase,
    private val postItemMapper: PostItemMapper,
    private val commentItemMapper: CommentItemMapper
) : ViewModel() {

    private val _loading = MediatorLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    val showEmptyView: LiveData<Boolean>

    private val postDetailsResult = MutableLiveData<Result<PostItem>>()
    private val commentListResult = MutableLiveData<Result<List<CommentItem>>>()

    private val _errorMessage = MediatorLiveData<Event<String>>()
    val errorMessage: LiveData<Event<String>>
        get() = _errorMessage

    private val _commentList = MediatorLiveData<List<CommentItem>>()
    val commentList: LiveData<List<CommentItem>>
        get() = _commentList

    private val _commentsNum = MediatorLiveData<Int>()
    val commentsNum: LiveData<Int>
        get() = _commentsNum

    private val _postDetails = MediatorLiveData<PostItem>()
    val postDetails: LiveData<PostItem>
        get() = _postDetails

    private val compositeDisposable = CompositeDisposable()

    init {
        _loading.addSource(commentListResult) {
            _loading.postValue(it is Result.Loading)
        }

        _loading.addSource(postDetailsResult) {
            _loading.postValue(it is Result.Loading)
        }

        showEmptyView = observeEmptyFrom(commentListResult)

        _errorMessage.observeErrorFrom(postDetailsResult)
        _errorMessage.observeErrorFrom(commentListResult)

        _postDetails.observeDataFrom(postDetailsResult)
        _commentList.observeDataFrom(commentListResult)
        _commentsNum.observeDataFrom(commentListResult) {
            it.size
        }

    }

    fun onScreenStarted(userId: String, postId: String) {
        getPost(userId, postId)
        getComment(postId)
    }


    private fun getPost(userId: String, postId: String) = compositeDisposable.add(
        getUserPostUseCase.get(userId, postId)
            .doOnSubscribe { postDetailsResult.postValue(Result.Loading()) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map { postItemMapper.mapToPresentation(it) }
            .subscribe({
                postDetailsResult.postValue(Result.Success(it))
            }, {
                postDetailsResult.postValue(Result.Error(it.localizedMessage))
            })
    )

    private fun getComment(postId: String) = compositeDisposable.add(
        getPostCommentsUseCase.get(postId)
            .doOnSubscribe { commentListResult.postValue(Result.Loading()) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map { commentItemMapper.mapToPresentation(it) }
            .subscribe({
                commentListResult.postValue(Result.Success(it))
            }, {
                commentListResult.postValue(Result.Error(it.localizedMessage))
            })
    )

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}