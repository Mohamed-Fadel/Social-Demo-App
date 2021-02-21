package com.example.newsfeedtestapp.ui.post

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsfeedtestapp.R
import com.example.newsfeedtestapp.databinding.ActivityPostDetailsBinding
import com.example.newsfeedtestapp.extensions.viewModelProvider
import com.example.newsfeedtestapp.presentation.postlist.models.CommentItem
import com.example.newsfeedtestapp.presentation.postlist.viewmodel.PostDetailsViewModel
import com.example.newsfeedtestapp.presentation.result.EventObserver
import com.example.newsfeedtestapp.ui.BaseActivity
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_post_details.*
import kotlinx.android.synthetic.main.item_post.*
import javax.inject.Inject

const val EXTRA_USER_ID = "com.example.newsfeedtestapp.ui.post.user_id"
const val EXTRA_POST_ID = "com.example.newsfeedtestapp.ui.post.post_id"

class PostDetailsActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var postDetailsViewModel: PostDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postDetailsViewModel = viewModelProvider(viewModelFactory)

        DataBindingUtil.setContentView<ActivityPostDetailsBinding>(
            this,
            R.layout.activity_post_details
        )
            .apply {
                viewModel = postDetailsViewModel
                lifecycleOwner = this@PostDetailsActivity
            }

        postDetailsViewModel.errorMessage.observe(this, EventObserver {
            Toasty.error(this@PostDetailsActivity, it)
        })

        postDetailsViewModel.commentList.observe(this, Observer { list ->
            setupCommentList(list)
        })

        postDetailsViewModel.commentsNum.observe(this, Observer {
            setCommentNumberText(it)
        })

        removeMaxLineLimits()

        val userId = intent!!.getStringExtra(EXTRA_USER_ID)!!
        val postId = intent!!.getStringExtra(EXTRA_POST_ID)!!

        postDetailsViewModel.onScreenStarted(userId, postId)

        post_swipe_refresh.setOnRefreshListener {
            postDetailsViewModel.onScreenStarted(userId, postId)
        }

    }

    private fun setCommentNumberText(count: Int) {
        post_comments_header.text =
            resources.getQuantityString(R.plurals.comments_label, count, count)
    }

    private fun setupCommentList(list: List<CommentItem>) {
        rvList.adapter = CommentListAdapter {
        }.apply {
            submitList(list.toMutableList())
        }
    }

    private fun removeMaxLineLimits() {
        // We are re-using the Feed Item layout.
        // Remove restrictions that exists on Feed.
        feed_item_title.maxLines = Integer.MAX_VALUE
        feed_item_desc.maxLines = Integer.MAX_VALUE
    }
}