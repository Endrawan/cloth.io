package com.example.cloth_io.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloth_io.R.drawable.ic_left_arrow_white_24dp
import com.example.cloth_io.R.layout.activity_seller
import com.example.cloth_io.adapters.SellerPagerAdapter
import com.example.cloth_io.fragments.InfoFragment
import com.example.cloth_io.fragments.ProductsFragment
import com.example.cloth_io.fragments.SellerReviewFragment
import kotlinx.android.synthetic.main.activity_seller.*

class SellerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_seller)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(ic_left_arrow_white_24dp)

        val adapter = SellerPagerAdapter(supportFragmentManager)
        adapter.addFrag(ProductsFragment(), "Produk")
        adapter.addFrag(SellerReviewFragment(), "Review")
        adapter.addFrag(InfoFragment(), "Info")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
//        nestedScrollView.isFillViewport = true
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        onBackPressed()
    }
}
