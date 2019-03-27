package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.item_grid_recent_viewed
import kotlinx.android.synthetic.main.item_grid_recent_viewed.view.*

class RecentsViewedAdapter(private val data: Array<String>, private val images: Array<Int>) : RecyclerView.Adapter<RecentsViewedAdapter.RecentViewedViewHolder>() {

    private lateinit var ctx: Context

    class RecentViewedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String, image:Int, ctx : Context) {
//            itemView.delete.setOnClickListener{action()}
            Glide.with(ctx).load(image).into(itemView.image)
            itemView.name.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewedViewHolder {
        ctx = parent.context

        return RecentViewedViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_grid_recent_viewed,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecentViewedViewHolder, p1: Int) {
        holder.bindItem(data[p1], images[p1], ctx)
    }
}