package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.drawable.avatar2
import com.example.cloth_io.R.drawable.feed
import com.example.cloth_io.R.layout.item_linear_feed
import kotlinx.android.synthetic.main.item_linear_feed.view.*

class FeedsAdapter(private val MyDataset: Array<String>) : RecyclerView.Adapter<FeedsAdapter.FeedViewHolder>() {

    private lateinit var ctx : Context

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String, ctx: Context) {
            itemView.feedTitle.text = data
            Glide.with(ctx).load(avatar2).into(itemView.profileImage)
            Glide.with(ctx).load(feed).into(itemView.feedImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder  {
        ctx = parent.context

        return FeedViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_linear_feed,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = MyDataset.size

    override fun onBindViewHolder(holder: FeedViewHolder, p1: Int) {
        holder.bindItem(MyDataset[p1], ctx)
    }
}