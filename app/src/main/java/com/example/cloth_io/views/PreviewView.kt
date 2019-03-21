package com.example.cloth_io.views

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import com.example.cloth_io.R.layout.view_preview
import com.example.cloth_io.R.styleable.*
import kotlinx.android.synthetic.main.view_preview.view.*

class PreviewView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private lateinit var recyclerView: RecyclerView

    constructor(context: Context) : this(context, null)

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            PreviewView, 0, 0
        )
        val actionName = a.getString(PreviewView_previewActionName)
        val title = a.getString(PreviewView_previewTitle)

        a.recycle()

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(view_preview, this, true)

        view.name.text = title
        view.previewAction.text = actionName
        recyclerView = view.recyclerView
    }

    fun setRecyclerView(
        adapter: RecyclerView.Adapter<*>,
        layoutManager: RecyclerView.LayoutManager,
        decoration: RecyclerView.ItemDecoration?
    ) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        if (decoration != null)
            recyclerView.addItemDecoration(decoration)
    }
}