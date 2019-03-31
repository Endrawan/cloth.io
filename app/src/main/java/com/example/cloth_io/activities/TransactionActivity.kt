package com.example.cloth_io.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloth_io.R
import com.example.cloth_io.R.layout.activity_transaction
import com.example.cloth_io.adapters.SellerPagerAdapter
import com.example.cloth_io.fragments.TransactionsFragment
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_transaction)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_left_arrow_black_24dp)

        val adapter = SellerPagerAdapter(supportFragmentManager)
        adapter.addFrag(TransactionsFragment(), "Belum Bayar")
        adapter.addFrag(TransactionsFragment(), "Dikemas")
        adapter.addFrag(TransactionsFragment(), "Terima")
        adapter.addFrag(TransactionsFragment(), "Selesai")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
