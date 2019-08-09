package com.example.cloth_io.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.item_linear_trivia
import com.example.cloth_io.models.Trivia
import kotlinx.android.synthetic.main.item_linear_trivia.view.*

class TriviasAdapter(private val trivias: MutableList<Trivia>, private val action: (Trivia) -> Unit) : RecyclerView.Adapter<TriviasAdapter.TriviaViewHolder>() {

    private lateinit var ctx:Context

    class TriviaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(trivia : Trivia, ctx:Context, action: (Trivia) -> Unit) {
            itemView.title.text = trivia.name
            itemView.subtitle.text= trivia.content
            Glide.with(ctx).load(trivia.img).into(itemView.image)
            itemView.setOnClickListener { action(trivia) }
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

    override fun getItemCount(): Int = trivias.size

    override fun onBindViewHolder(holder: TriviaViewHolder, p1: Int) {
        holder.bindItem(trivias[p1], ctx, action)
    }
}