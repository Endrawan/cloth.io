package com.example.cloth_io.views

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.cloth_io.R
import com.example.cloth_io.R.color.black
import com.example.cloth_io.R.color.white
import com.example.cloth_io.R.layout.view_step
import com.example.cloth_io.R.styleable.*
import kotlinx.android.synthetic.main.view_step.view.*

class StepView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    constructor(context: Context) : this(context, null)

    private var view: View

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            StepView, 0, 0
        )
        val name = a.getString(StepView_stepName)
        val state = a.getInt(StepView_stepState, 0)

        a.recycle()

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = inflater.inflate(view_step, this , true)

        view.step.text = name

        when (state) {
            0 -> setUnselected()
            1 -> setSelected()
            2 -> setDone()
        }

    }

    fun setUnselected() {
        view.step.background = null
        view.step.setTextColor(ContextCompat.getColor(context, black))
        view.step.setCompoundDrawables(null, null, null, null)
    }

    fun setSelected() {
        view.step.background = ContextCompat.getDrawable(context, R.drawable.background_rounded_blue)
        view.step.setTextColor(ContextCompat.getColor(context, white))
        view.step.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
    }

    fun setDone() {
//        view.step.background = ContextCompat.getDrawable(context, R.drawable.background_rounded_green)
        view.step.background = null
        view.step.setTextColor(ContextCompat.getColor(context, black))
        view.step.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(context, R.drawable.ic_done_black_16dp), null, null, null)
    }
}