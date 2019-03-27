package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R.layout.item_linear_search_suggestion
import kotlinx.android.synthetic.main.item_linear_search_suggestion.view.*

class SuggestionsAdapter(private val data: Array<String>) : RecyclerView.Adapter<SuggestionsAdapter.SuggestionViewHolder>() {

    private lateinit var ctx: Context

    class SuggestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String) {
            itemView.text.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        ctx = parent.context

        return SuggestionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                item_linear_search_suggestion,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SuggestionViewHolder, p1: Int) {
        holder.bindItem(data[p1])
    }
}