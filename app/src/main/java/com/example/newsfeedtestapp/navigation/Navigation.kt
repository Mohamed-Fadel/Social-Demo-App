package com.example.newsfeedtestapp.navigation

import android.app.Activity
import android.content.Intent
import com.example.newsfeedtestapp.presentation.postlist.models.PostItem
import com.example.newsfeedtestapp.ui.post.EXTRA_POST_ID
import com.example.newsfeedtestapp.ui.post.EXTRA_USER_ID
import com.example.newsfeedtestapp.ui.post.PostDetailsActivity
import javax.inject.Inject


class PostListNavigator @Inject constructor() {

    fun navigate(activity: Activity, postItem: PostItem) {
        val intent = Intent(activity, PostDetailsActivity::class.java)
        intent.putExtra(EXTRA_USER_ID, postItem.userId)
        intent.putExtra(EXTRA_POST_ID, postItem.postId)
        activity.startActivity(intent)
    }

}