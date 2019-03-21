package com.example.cloth_io.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R.layout.item_linear_trivia
import kotlinx.android.synthetic.main.item_linear_trivia.view.*

class TriviasAdapter(private val MyDataset: Array<String>) : RecyclerView.Adapter<TriviasAdapter.TriviaViewHolder>() {

    class TriviaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String) {
            itemView.title.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TriviaViewHolder = TriviaViewHolder(
        LayoutInflater.from(parent.context).inflate(
        item_linear_trivia,
        parent,
        false
    ))

    override fun getItemCount(): Int = MyDataset.size

    override fun onBindViewHolder(holder: TriviaViewHolder, p1: Int) {
        holder.bindItem(MyDataset[p1])
    }
}