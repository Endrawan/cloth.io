package com.example.cloth_io.activities

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.cloth_io.R.drawable.ic_left_arrow_white_24dp
import com.example.cloth_io.R.layout.activity_seller
import com.example.cloth_io.adapters.SellerPagerAdapter
import com.example.cloth_io.fragments.InfoFragment
import com.example.cloth_io.fragments.ProductsFragment
import com.example.cloth_io.fragments.SellerReviewFragment
import com.example.cloth_io.models.Konveksi
import components.AppCompatActivity
import kotlinx.android.synthetic.main.activity_seller.*

class SellerActivity : AppCompatActivity() {

    lateinit var konveksi: Konveksi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_seller)

        val konveksiJSON = intent.getStringExtra("konveksi")
        konveksi = gson.fromJson<Konveksi>(konveksiJSON, Konveksi::class.java)
        name.text = konveksi.nama_konveksi
        location.text = konveksi.alamat_konveksi
        Glide.with(this).load(konveksi.img).into(icon)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(ic_left_arrow_white_24dp)

        val adapter = SellerPagerAdapter(supportFragmentManager)
        adapter.addFrag(ProductsFragment(), "Produk")
        adapter.addFrag(SellerReviewFragment(), "Review")
        adapter.addFrag(InfoFragment(), "Info")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)


    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        onBackPressed()
    }
}
