package com.example.cloth_io.fragments


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cloth_io.R
import com.example.cloth_io.adapters.AutoCompleteAdapter
import com.example.cloth_io.others.GridSpacingItemDecoration
import components.Fragment
import kotlinx.android.synthetic.main.fragment_search_auto_complete.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchAutoCompleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_auto_complete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = AutoCompleteAdapter(arrayOf("Gucci Gang", "Bank Account", "A Lot", "Middle Child", "FEFE"))
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(GridSpacingItemDecoration(1, GridSpacingItemDecoration.dpToPx(16, activity!!), true))
    }


}
