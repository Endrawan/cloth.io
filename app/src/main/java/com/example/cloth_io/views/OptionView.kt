package com.example.cloth_io.views

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.example.cloth_io.R.layout.view_option
import com.example.cloth_io.R.styleable.*
import kotlinx.android.synthetic.main.view_option.view.*

class OptionView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    constructor(context: Context) : this(context, null)

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            OptionView, 0, 0
        )
        val title = a.getString(OptionView_optionTitle)
        val subtitle = a.getString(OptionView_optionSubtitle)
        val icon = a.getDrawable(OptionView_optionIcon)

        a.recycle()

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(view_option, this, true)

        view.title.text = title
        view.subtitle.text = subtitle
        view.icon.setImageDrawable(icon)
    }
}