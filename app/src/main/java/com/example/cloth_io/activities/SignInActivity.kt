package com.example.cloth_io.activities

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.cloth_io.R
import com.example.cloth_io.R.layout.activity_sign_in
import components.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_sign_in)

        Glide.with(this).load(R.drawable.icon).into(icon)
    }
}
