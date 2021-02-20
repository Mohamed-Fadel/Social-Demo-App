package com.example.newsfeedtestapp.ui.postlist

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.newsfeedtestapp.R
import com.example.newsfeedtestapp.databinding.ActivityPostListBinding
import com.example.newsfeedtestapp.extensions.viewModelProvider
import com.example.newsfeedtestapp.presentation.postlist.viewmodel.PostListViewModel
import com.example.newsfeedtestapp.ui.BaseActivity
import javax.inject.Inject

class PostListActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var postListViewModel: PostListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postListViewModel = viewModelProvider(viewModelFactory)

        DataBindingUtil.setContentView<ActivityPostListBinding>(this, R.layout.activity_post_list)
            .apply {
                viewModel = postListViewModel
                lifecycleOwner = this@PostListActivity
            }
    }
}