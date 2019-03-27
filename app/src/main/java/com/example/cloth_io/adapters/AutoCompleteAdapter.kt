package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R.layout.item_linear_search_autocomplete
import kotlinx.android.synthetic.main.item_linear_search_autocomplete.view.*

class AutoCompleteAdapter(private val data: Array<String>) : RecyclerView.Adapter<AutoCompleteAdapter.AutoCompleteViewHolder>() {

    private lateinit var ctx: Context

    class AutoCompleteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String) {
            itemView.text.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoCompleteViewHolder {
        ctx = parent.context

        return AutoCompleteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_linear_search_autocomplete,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AutoCompleteViewHolder, p1: Int) {
        holder.bindItem(data[p1])
    }
}