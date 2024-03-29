package com.example.cloth_io.fragments.main


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R
import com.example.cloth_io.activities.FeedActivity
import com.example.cloth_io.adapters.FeedsAdapter
import com.example.cloth_io.others.Dummy
import com.example.cloth_io.others.GridSpacingItemDecoration
import com.google.gson.Gson
import components.Fragment
import kotlinx.android.synthetic.main.fragment_feed.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FeedFragment : Fragment() {

    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        fragmentTag = "feed"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity.setSupportActionBar(toolbar)
        mActivity.supportActionBar?.title = "Feed"

        val adapter = FeedsAdapter(Dummy.products) {
            val intent = Intent(context, FeedActivity::class.java)
            intent.putExtra("product", gson.toJson(it))
            startActivity(intent)
        }
        val linearLayoutManager = LinearLayoutManager(mActivity)
        val spacing = GridSpacingItemDecoration(1, GridSpacingItemDecoration.dpToPx(12, mActivity), true)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addItemDecoration(spacing)
        recyclerView.adapter = adapter

    }

}
