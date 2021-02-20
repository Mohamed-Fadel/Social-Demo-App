package com.example.newsfeedtestapp.ui.postlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeedtestapp.databinding.ItemPostBinding
import com.example.newsfeedtestapp.presentation.postlist.models.PostItem

/**
 * Created by Mohamed Fadel
 * Date: 2/6/2020.
 * email: mohamedfadel91@gmail.com.
 */
class PostListAdapter(private val postClickFunc: (PostItem) -> Unit) :
    ListAdapter<PostItem, PostListAdapter.PostViewHolder>(PostDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), postClickFunc
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PostViewHolder(
        private val binding: ItemPostBinding,
        private val postClickFunc: (PostItem) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostItem) {
            binding.post = item
            binding.root.setOnClickListener {
                postClickFunc.invoke(item)
            }
        }
    }

    object PostDiff : DiffUtil.ItemCallback<PostItem>() {
        override fun areItemsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
            return oldItem.postId == newItem.postId
        }
    }

}


