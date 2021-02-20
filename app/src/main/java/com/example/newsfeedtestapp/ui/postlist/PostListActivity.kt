package com.example.newsfeedtestapp.ui.postlist

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsfeedtestapp.R
import com.example.newsfeedtestapp.databinding.ActivityPostListBinding
import com.example.newsfeedtestapp.extensions.viewModelProvider
import com.example.newsfeedtestapp.presentation.postlist.viewmodel.PostListViewModel
import com.example.newsfeedtestapp.presentation.result.EventObserver
import com.example.newsfeedtestapp.ui.BaseActivity
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_post_list.*
import javax.inject.Inject

class PostListActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var postListViewModel: PostListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postListViewModel = viewModelProvider(viewModelFactory)

        DataBindingUtil.setContentView<ActivityPostListBinding>(
            this,
            R.layout.activity_post_list
        )
            .apply {
                viewModel = postListViewModel
                lifecycleOwner = this@PostListActivity
            }

        postListViewModel.errorMessage.observe(this, EventObserver {
            Toasty.error(this@PostListActivity, it)
        })

        postListViewModel.postList.observe(this, Observer { list ->
            rvList.adapter = PostListAdapter {
            }.apply {
                submitList(list.toMutableList())
            }

        })

    }
}