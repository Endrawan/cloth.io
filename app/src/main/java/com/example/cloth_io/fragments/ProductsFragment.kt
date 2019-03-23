package com.example.cloth_io.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.cloth_io.R
import com.example.cloth_io.activities.SellerActivity
import com.example.cloth_io.adapters.ProductsAdapter
import com.example.cloth_io.others.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_products.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductsAdapter(arrayOf("Louis Vuitton", "Gucci", "Fendi", "Versace", "Balenciaga", "Saint Laurent", "Chanel", "Hermes")) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            startActivity(Intent(context, SellerActivity::class.java))
        }
        val layoutManager = GridLayoutManager(context, 2)
        val decoration = GridSpacingItemDecoration(
            2,
            GridSpacingItemDecoration.dpToPx(12, context!!),
            true
        )
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(decoration)
        recyclerView.adapter = adapter
    }


}