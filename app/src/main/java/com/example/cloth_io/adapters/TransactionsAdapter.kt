package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.item_linear_transaction
import kotlinx.android.synthetic.main.item_linear_transaction.view.*

class TransactionsAdapter(private val images: Array<Int>) : RecyclerView.Adapter<TransactionsAdapter.OrderViewHolder>() {

    private lateinit var ctx: Context

    class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(image : Int, ctx : Context) {
            Glide.with(ctx).load(image).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        ctx = parent.context

        return OrderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_linear_transaction,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: OrderViewHolder, p1: Int) {
        holder.bindItem(images[p1], ctx)
    }
}