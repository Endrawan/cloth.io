package com.example.cloth_io.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.cloth_io.R
import com.example.cloth_io.fragments.FeedFragment
import com.example.cloth_io.fragments.HomeFragment
import com.example.cloth_io.fragments.ProfileFragment
import com.example.cloth_io.fragments.TriviaFragment
import components.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    transaction(HomeFragment(), false, null)
                    true
                }
                R.id.feed -> {
                    transaction(FeedFragment(), false, null)
                    true
                }
                R.id.trivia -> {
                    transaction(TriviaFragment(), false, null)
                    true
                }
                R.id.profile -> {
                    transaction(ProfileFragment(), false, null)
                    true
                }
                else -> false
            }
        }

        bottom_nav.selectedItemId = R.id.home
    }

    fun transaction(fragment: Fragment, addToBackStack: Boolean, tag:String?) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        if (addToBackStack && tag != null)
            fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
        //container.fitsSystemWindows = true
    }
}
