package com.example.cloth_io.fragments.main


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R.layout.fragment_trivia
import com.example.cloth_io.adapters.TriviasAdapter
import com.example.cloth_io.others.Dummy
import com.example.cloth_io.others.GridSpacingItemDecoration
import components.Fragment
import kotlinx.android.synthetic.main.fragment_trivia.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TriviaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentTag = "trivia"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(fragment_trivia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity.setSupportActionBar(toolbar)
        mActivity.supportActionBar?.title = "Trivia"

        val adapter = TriviasAdapter(Dummy.trivias)
        val spacing = GridSpacingItemDecoration(1, GridSpacingItemDecoration.dpToPx(8, mActivity), true)
        val linearLayoutManager = LinearLayoutManager(mActivity)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addItemDecoration(spacing)
        recyclerView.adapter = adapter
    }


}
