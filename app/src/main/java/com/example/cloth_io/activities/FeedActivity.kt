package com.example.cloth_io.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.cloth_io.R.layout.activity_feed
import com.example.cloth_io.models.Product
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {

    private lateinit var product: Product
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_feed)

        product = gson.fromJson(intent.getStringExtra("product"), Product::class.java)
        Glide.with(this).load(product.img).into(image)
        desc.text = product.description
        feedTitle.text = product.name
    }
}
