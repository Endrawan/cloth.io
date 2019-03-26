package com.example.cloth_io.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cloth_io.R
import com.example.cloth_io.activities.CheckOutActivity
import com.example.cloth_io.adapters.AddressesAdapter
import kotlinx.android.synthetic.main.fragment_shipment.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ShipmentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shipment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mActivity = activity as CheckOutActivity
        next.setOnClickListener {
            mActivity.changeStep(++mActivity.step)
            mActivity.transaction(mActivity.fragments[mActivity.step], true, mActivity.step.toString())
        }

        addresses.adapter = AddressesAdapter(arrayOf("Rumah", "Kontrakan", "Kantor"))
        addresses.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false)


    }


}
