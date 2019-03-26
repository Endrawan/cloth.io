package com.example.cloth_io.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cloth_io.R
import com.example.cloth_io.activities.CheckOutActivity
import com.example.cloth_io.adapters.DesignsAdapter
import com.example.cloth_io.adapters.MaterialsAdapter
import kotlinx.android.synthetic.main.fragment_order.*
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mActivity = activity as CheckOutActivity
        next.setOnClickListener {
            mActivity.changeStep(++mActivity.step)
            mActivity.transaction(mActivity.fragments[mActivity.step], true, mActivity.step.toString())
        }

        val designsAdapter = DesignsAdapter(arrayOf(R.drawable.product3, R.drawable.product2, R.drawable.product3)) {
            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
        }
        val materialsAdapter = MaterialsAdapter(arrayOf(R.drawable.product3, R.drawable.product2, R.drawable.product3)) {
            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
        }

        designList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        designList.adapter = designsAdapter

        materials.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        materials.adapter = materialsAdapter
//        materials.addItemDecoration(GridSpacingItemDecoration(2, GridSpacingItemDecoration.dpToPx(8, mActivity), false))

        val calendar = Calendar.getInstance()
        val date = DatePickerDialog.OnDateSetListener{ view, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(calendar)
        }

        datePicker.setOnClickListener {
            DatePickerDialog(mActivity, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

    }

    private fun updateLabel(calendar:Calendar) {
        val format = "dd MMMM yyyy"
        val locale = Locale("in", "ID")
        val sdf = SimpleDateFormat(format, locale)
        datePicker.setText(sdf.format(calendar.time))
    }

}
