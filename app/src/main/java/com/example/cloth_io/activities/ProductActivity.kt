package com.example.cloth_io.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R
import com.example.cloth_io.R.drawable.ic_left_arrow_white_24dp
import com.example.cloth_io.R.layout.activity_product
import com.example.cloth_io.adapters.ReviewAdapter
import com.example.cloth_io.adapters.SliderAdapter
import com.example.cloth_io.others.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_product.*


class ProductActivity : AppCompatActivity() {

    private val ads_data:MutableList<Int> = arrayListOf(
        R.drawable.product,
        R.drawable.product2,
        R.drawable.product3,
        R.drawable.product2
    )
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_product)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(ic_left_arrow_white_24dp)

        setMargins(collapseToolbar, 0, 0, 0, -getStatusBarHeight())

        initSlider()

        val adapter = ReviewAdapter(arrayOf("Ezechiel N'douassel", "Jonathan Bauman", "Atep"), false)
        val layoutManager = LinearLayoutManager(this)
        val spacing = GridSpacingItemDecoration(1,
            GridSpacingItemDecoration.dpToPx(16, this),
            false)

        reviewList.layoutManager = layoutManager
        reviewList.addItemDecoration(spacing)
        reviewList.adapter = adapter

        order.setOnClickListener {
            startActivity(Intent(this, CheckOutActivity::class.java))
        }

    }

    private fun setMargins(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val p = view.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(left, top, right, bottom)
            view.requestLayout()
        }
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    private fun initSlider() {
        productImg.adapter = SliderAdapter(this, ads_data)
        imgIndicator.setupWithViewPager(productImg)
    }
}
