package com.example.cloth_io.fragments


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R
import com.example.cloth_io.adapters.FeedsAdapter
import com.example.cloth_io.others.GridSpacingItemDecoration
import components.AppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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

        mActivity = activity as AppCompatActivity
        mActivity.setSupportActionBar(toolbar)
        mActivity.supportActionBar?.title = "Feed"

        val adapter = FeedsAdapter(arrayOf("Air Jordan 1 Spiderman", "NMD Human Race", "Travis Scott Air Jordan 1 Jack Cactus", "Drake OVO Air Jordan"))
        val linearLayoutManager = LinearLayoutManager(mActivity)
        val spacing = GridSpacingItemDecoration(1, GridSpacingItemDecoration.dpToPx(12, mActivity), true)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addItemDecoration(spacing)
        recyclerView.adapter = adapter

    }

}
