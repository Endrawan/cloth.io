package com.example.cloth_io.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SellerPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val fragments: MutableList<Fragment> = arrayListOf()
    private val titles: MutableList<String> = arrayListOf()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun addFrag(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}