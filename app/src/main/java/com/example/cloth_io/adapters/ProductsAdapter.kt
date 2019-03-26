package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.drawable.product3
import com.example.cloth_io.R.layout.item_grid_product
import kotlinx.android.synthetic.main.item_grid_product.view.*

class ProductsAdapter(private val MyDataset: Array<String>, private val action: (String) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private lateinit var ctx: Context

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String, ctx : Context, action:(String) -> Unit) {
            itemView.setOnClickListener { action(data) }
            itemView.name.text = data
            Glide.with(ctx).load(product3).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        ctx = parent.context

        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_grid_product,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = MyDataset.size

    override fun onBindViewHolder(holder: ProductViewHolder, p1: Int) {
        holder.bindItem(MyDataset[p1], ctx, action)
    }
}