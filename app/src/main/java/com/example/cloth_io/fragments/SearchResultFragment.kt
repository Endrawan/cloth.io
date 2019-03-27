package com.example.cloth_io.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.*
import com.example.cloth_io.R
import com.example.cloth_io.activities.ProductActivity
import com.example.cloth_io.adapters.ProductsAdapter
import com.example.cloth_io.others.GridSpacingItemDecoration
import components.Fragment
import kotlinx.android.synthetic.main.fragment_search_result.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity.setSupportActionBar(toolbar)

        val adapter = ProductsAdapter(arrayOf("Outerwear", "Hats", "Kits", "Versace", "Balenciaga", "Saint Laurent", "Chanel", "Hermes")) {
            startActivity(Intent(context, ProductActivity::class.java))
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

        toolbar.setOnClickListener {
            mActivity.transaction(SearchFragment(), true, "search_result")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        mActivity.menuInflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cart -> {
                // TODO Add cart action here
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
