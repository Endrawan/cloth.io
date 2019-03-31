package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.item_grid_seller
import com.example.cloth_io.models.Konveksi
import kotlinx.android.synthetic.main.item_grid_product.view.*

class SellersAdapter(private val konveksiList: MutableList<Konveksi>, private val action: (Konveksi) -> Unit) : RecyclerView.Adapter<SellersAdapter.SellerViewHolder>() {

    private lateinit var ctx: Context

    class SellerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(konveksi: Konveksi, ctx : Context, action:(Konveksi) -> Unit) {
            itemView.setOnClickListener { action(konveksi) }
            itemView.name.text = konveksi.nama_konveksi
            itemView.rating.text = konveksi.rating_konveksi?.toFloat().toString()
            Glide.with(ctx).load(konveksi.img).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerViewHolder {
        ctx = parent.context

        return SellerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_grid_seller,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = konveksiList.size

    override fun onBindViewHolder(holder: SellerViewHolder, p1: Int) {
        holder.bindItem(konveksiList[p1], ctx, action)
    }
}