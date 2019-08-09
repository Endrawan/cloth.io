package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.item_linear_feed
import com.example.cloth_io.models.Product
import kotlinx.android.synthetic.main.item_linear_feed.view.*

class FeedsAdapter(private val feeds: MutableList<Product>, private val action: (Product) -> Unit) : RecyclerView.Adapter<FeedsAdapter.FeedViewHolder>() {

    private lateinit var ctx : Context

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(product : Product, ctx: Context, action: (Product) -> Unit) {
            itemView.feedTitle.text = product.name
            itemView.feedDesc.text = product.description
//            Glide.with(ctx).load(avatar2).into(itemView.profileImage)
            Glide.with(ctx).load(product.img).into(itemView.feedImage)
            if(product.mitra != null) {
                Glide.with(ctx).load(product.mitra!!.img).into(itemView.profileImage)
                itemView.profileName.text = product.mitra!!.nama_tokoBaju
            }
            itemView.setOnClickListener { action(product) }
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

    override fun getItemCount(): Int = feeds.size

    override fun onBindViewHolder(holder: FeedViewHolder, p1: Int) {
        holder.bindItem(feeds[p1], ctx, action)
    }
}