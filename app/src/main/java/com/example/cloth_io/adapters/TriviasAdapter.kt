package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.item_linear_trivia
import kotlinx.android.synthetic.main.item_linear_trivia.view.*

class TriviasAdapter(private val MyDataset: Array<String>, private val MyImg: Array<Int>) : RecyclerView.Adapter<TriviasAdapter.TriviaViewHolder>() {

    private lateinit var ctx:Context

    class TriviaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data : String, img: Int, ctx:Context) {
            itemView.title.text = data
            Glide.with(ctx).load(img).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TriviaViewHolder {
        ctx = parent.context
        return TriviaViewHolder(
            LayoutInflater.from(ctx).inflate(
                item_linear_trivia,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int = MyDataset.size

    override fun onBindViewHolder(holder: TriviaViewHolder, p1: Int) {
        holder.bindItem(MyDataset[p1], MyImg[p1], ctx)
    }
}