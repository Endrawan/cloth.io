package com.example.cloth_io.views

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.example.cloth_io.R.layout.view_preview
import com.example.cloth_io.R.styleable.*
import kotlinx.android.synthetic.main.view_preview.view.*

class PreviewView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    var mRecyclerView: RecyclerView
    var mTitle: TextView

    constructor(context: Context) : this(context, null)

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            PreviewView, 0, 0
        )
        val actionName = a.getString(PreviewView_previewActionName)
        val title = a.getString(PreviewView_previewTitle)
        val actionVisibility = a.getInt(PreviewView_previewActionVisibility, 0)

        a.recycle()

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(view_preview, this, true)

        mTitle = view.name
        mRecyclerView = view.recyclerView
        mTitle.text = title
        view.previewAction.text = actionName

        when (actionVisibility) {
            1 -> {previewAction.visibility = android.view.View.INVISIBLE}
            else ->{previewAction.visibility = android.view.View.VISIBLE}
        }
    }

    fun setRecyclerView(
        adapter: RecyclerView.Adapter<*>,
        layoutManager: RecyclerView.LayoutManager,
        decoration: RecyclerView.ItemDecoration?
    ) {
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = layoutManager
        if (decoration != null)
            mRecyclerView.addItemDecoration(decoration)
    }
}