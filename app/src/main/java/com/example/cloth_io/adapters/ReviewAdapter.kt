package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.drawable.product3
import com.example.cloth_io.R.layout.item_linear_review
import kotlinx.android.synthetic.main.item_linear_review.view.*

class ReviewAdapter(private val MyDataset: Array<String>, private val showProduct:Boolean): RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    private lateinit var ctx: Context

    class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String, ctx : Context, showProduct: Boolean) {
            if(!showProduct) itemView.product.visibility = View.GONE
            itemView.reviewerName.text = data
            Glide.with(ctx).load(product3).into(itemView.productImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        ctx = parent.context

        return ReviewViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_linear_review,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = MyDataset.size

    override fun onBindViewHolder(holder: ReviewViewHolder, p1: Int) {
        holder.bindItem(MyDataset[p1], ctx, showProduct)
    }
}