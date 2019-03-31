package com.example.cloth_io.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cloth_io.R.drawable.ic_left_arrow_white_24dp
import com.example.cloth_io.R.layout.activity_product
import com.example.cloth_io.adapters.ReviewAdapter
import com.example.cloth_io.adapters.SliderAdapter
import com.example.cloth_io.models.Konveksi
import com.example.cloth_io.models.Product
import com.example.cloth_io.others.GridSpacingItemDecoration
import components.AppCompatActivity
import kotlinx.android.synthetic.main.activity_product.*


class ProductActivity : AppCompatActivity() {

    private lateinit var product:Product
    private lateinit var konveksi: Konveksi

    private val images:MutableList<Int> = arrayListOf()
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_product)

        val productJSON = intent.getStringExtra("product")
        val konveksiJSON = intent.getStringExtra("konveksi")
        product = gson.fromJson<Product>(productJSON, Product::class.java)
        konveksi = gson.fromJson<Konveksi>(konveksiJSON, Konveksi::class.java)
        images.add(product.img!!)
        price.text = "Rp ${product.price},-"
        name.text = product.name
        description.text = product.description
        sellerName.text = konveksi.nama_konveksi
        sellerLocation.text = konveksi.alamat_konveksi
        Glide.with(this).load(konveksi.img).into(sellerImg)

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
        productImg.adapter = SliderAdapter(this, images)
        imgIndicator.setupWithViewPager(productImg)
    }
}
