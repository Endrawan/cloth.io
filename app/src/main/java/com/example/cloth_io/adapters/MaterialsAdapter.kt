package com.example.cloth_io.adapters

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R
import com.example.cloth_io.R.layout.item_grid_material
import kotlinx.android.synthetic.main.item_grid_material.view.*

class MaterialsAdapter(private val images: Array<Int>, private val action: () -> Unit) : RecyclerView.Adapter<MaterialsAdapter.MaterialViewHolder>() {

    private lateinit var ctx: Context
    private var selected:Int = 0

    class MaterialViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(image : Int, ctx : Context, action:() -> Unit) {
            itemView.setOnClickListener{
                itemView.background = ContextCompat.getDrawable(ctx, R.drawable.border_rounded_blue)
                action()
            }
            Glide.with(ctx).load(image).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        ctx = parent.context

        return MaterialViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_grid_material,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: MaterialViewHolder, p1: Int) {
        holder.bindItem(images[p1], ctx, action)
    }
}