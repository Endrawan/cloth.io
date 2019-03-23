package com.example.cloth_io.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.cloth_io.R.layout.view_shipment
import com.example.cloth_io.R.styleable.*
import kotlinx.android.synthetic.main.view_shipment.view.*

class ShipmentView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    constructor(context: Context) : this(context, null)

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            ShipmentView, 0, 0
        )
        val name = a.getString(ShipmentView_shipmentName)
        val desc = a.getString(ShipmentView_shipmentDesc)
        val icon = a.getDrawable(ShipmentView_shipmentIcon)

        a.recycle()

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(view_shipment, this, true)

        view.name.text = name
        view.desc.text = desc
        view.icon.setImageDrawable(icon)
        //Glide.with(context).load(icon).into(view.icon)
    }
}