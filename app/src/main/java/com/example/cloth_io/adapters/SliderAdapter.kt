package com.example.cloth_io.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.cloth_io.R.id.image
import com.example.cloth_io.R.layout.item_slider

class SliderAdapter(private val context: Context, private val images:List<Int>) : PagerAdapter() {

    private val inflater = LayoutInflater.from(context)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(item_slider, container, false)
        val image = imageLayout.findViewById<ImageView>(image)
//        image.setImageResource()
        Glide.with(context).load(images[position]).into(image)
        container.addView(image, 0)
        return imageLayout
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }
}