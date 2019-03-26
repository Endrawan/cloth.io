package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.item_grid_design
import kotlinx.android.synthetic.main.item_grid_design.view.*

class DesignsAdapter(private val images: Array<Int>, private val deleteAction: () -> Unit) : RecyclerView.Adapter<DesignsAdapter.DesignViewHolder>() {

    private lateinit var ctx: Context

    class DesignViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(image : Int, ctx : Context, action:() -> Unit) {
            itemView.delete.setOnClickListener{action()}
            Glide.with(ctx).load(image).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesignViewHolder {
        ctx = parent.context

        return DesignViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_grid_design,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: DesignViewHolder, p1: Int) {
        holder.bindItem(images[p1], ctx, deleteAction)
    }
}