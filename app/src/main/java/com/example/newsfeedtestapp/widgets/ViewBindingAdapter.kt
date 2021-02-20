package com.example.newsfeedtestapp.widgets

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsfeedtestapp.R

/**
 * Created by Mohamed Fadel
 * Date: 10/28/2019.
 * email: mohamedfadel91@gmail.com.
 */
//@BindingAdapter("onClick")
//fun onClick(view: View, func: () -> Unit) {
//    view.setOnClickListener {
//        func.invoke()
//    }
//}

@BindingAdapter("goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("onRefresh")
fun onRefresh(view: SwipeRefreshLayout, func: () -> Unit) {
    view.setOnRefreshListener {
        func.invoke()
    }
}

@BindingAdapter("dismissRefresh")
fun dismissRefresh(view: SwipeRefreshLayout, visible: Boolean) {
    view.isRefreshing = visible
}

@BindingAdapter("loadCircleImage")
fun bindLoadCircleImage(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .error(R.drawable.ic_account)
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}


