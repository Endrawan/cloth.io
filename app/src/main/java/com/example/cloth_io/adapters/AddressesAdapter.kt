package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R.layout.item_grid_address
import kotlinx.android.synthetic.main.item_grid_address.view.*

class AddressesAdapter(private val data: Array<String>) : RecyclerView.Adapter<AddressesAdapter.AddressViewHolder>() {

    private lateinit var ctx: Context

    class AddressViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String, ctx : Context) {
//            itemView.delete.setOnClickListener{action()}
//            Glide.with(ctx).load(image).into(itemView.image)
            itemView.name.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        ctx = parent.context

        return AddressViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_grid_address,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AddressViewHolder, p1: Int) {
        holder.bindItem(data[p1], ctx)
    }
}