package com.example.newsfeedtestapp.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeedtestapp.databinding.ItemCommentBinding
import com.example.newsfeedtestapp.presentation.postlist.models.CommentItem

/**
 * Created by Mohamed Fadel
 * Date: 2/6/2020.
 * email: mohamedfadel91@gmail.com.
 */
class CommentListAdapter(private val postClickFunc: (CommentItem) -> Unit) :
    ListAdapter<CommentItem, CommentListAdapter.CommentViewHolder>(CommentDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            ItemCommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), postClickFunc
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CommentViewHolder(
        private val binding: ItemCommentBinding,
        private val postClickFunc: (CommentItem) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommentItem) {
            binding.comment = item
            binding.root.setOnClickListener {
                postClickFunc.invoke(item)
            }
        }
    }

    object CommentDiff : DiffUtil.ItemCallback<CommentItem>() {
        override fun areItemsTheSame(oldItem: CommentItem, newItem: CommentItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CommentItem, newItem: CommentItem): Boolean {
            return oldItem.postId == newItem.postId
        }
    }

}


