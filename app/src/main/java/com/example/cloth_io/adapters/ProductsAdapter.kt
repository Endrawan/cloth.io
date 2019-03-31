package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.item_grid_product
import com.example.cloth_io.models.Product
import kotlinx.android.synthetic.main.item_grid_product.view.*

class ProductsAdapter(private val products: MutableList<Product>, private val action: (Product) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private lateinit var ctx: Context

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(product : Product, ctx : Context, action:(Product) -> Unit) {
            itemView.setOnClickListener { action(product) }
            itemView.name.text = product.name
            itemView.price.text = "Rp ${product.price},-"
            Glide.with(ctx).load(product.img).into(itemView.image)
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

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, p1: Int) {
        holder.bindItem(products[p1], ctx, action)
    }
}