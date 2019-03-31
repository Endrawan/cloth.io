package com.example.cloth_io.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.example.cloth_io.R
import com.example.cloth_io.fragments.main.FeedFragment
import com.example.cloth_io.fragments.main.HomeFragment
import com.example.cloth_io.fragments.main.ProfileFragment
import com.example.cloth_io.fragments.main.TriviaFragment
import components.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mBottomNav:BottomNavigationView
    var activeTag:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBottomNav = bottom_nav
        mBottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    transaction(HomeFragment(), activeTag)
                    true
                }
                R.id.feed -> {
                    transaction(FeedFragment(), activeTag)
                    true
                }
                R.id.trivia -> {
                    transaction(TriviaFragment(), activeTag)
                    true
                }
                R.id.profile -> {
                    transaction(ProfileFragment(), activeTag)
                    true
                }
                else -> false
            }
        }

        mBottomNav.selectedItemId = R.id.home
        //toast(user.toString())
    }

    fun transaction(fragment: Fragment, tag:String?) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        if(tag != null) fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
    }
}
