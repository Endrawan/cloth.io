package com.example.cloth_io.fragments


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R
import com.example.cloth_io.adapters.RecentsViewedAdapter
import com.example.cloth_io.adapters.SuggestionsAdapter
import com.example.cloth_io.others.Extension
import components.Fragment
import kotlinx.android.synthetic.main.fragment_search_suggestions.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchSuggestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_suggestions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recentPreview.mTitle.textSize = 16f
        recentPreview.setRecyclerView(
            RecentsViewedAdapter(arrayOf("Richard Mille", "Louis Vuitton", "Hypebeast"), arrayOf(R.drawable.product, R.drawable.product2, R.drawable.product3)),
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false),null
            //DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        )
        val padding = Extension.dpToPx(16, activity!!)
        recentPreview.mRecyclerView.setPadding(padding, padding, 0, 0)

        popularPreview.mTitle.textSize = 16f
        popularPreview.setRecyclerView(SuggestionsAdapter(arrayOf("Los Intocables", "Los Illuminati", "Jokowi Raja Klaim", "Btp si munafik")),
            LinearLayoutManager(activity), null)
        popularPreview.mRecyclerView.setPadding(Extension.dpToPx(8, activity!!), 0, Extension.dpToPx(8, activity!!), 0)
    }


}
