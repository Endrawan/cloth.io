package com.example.cloth_io.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.cloth_io.R
import com.example.cloth_io.R.layout.activity_check_out
import com.example.cloth_io.fragments.OrderFragment
import com.example.cloth_io.fragments.PaymentFragment
import com.example.cloth_io.fragments.ShipmentFragment
import com.example.cloth_io.views.StepView
import components.AppCompatActivity
import kotlinx.android.synthetic.main.activity_check_out.*

class CheckOutActivity : AppCompatActivity() {

    private val mSteps:MutableList<StepView> = mutableListOf()
    val fragments:List<Fragment> = arrayListOf(OrderFragment(), ShipmentFragment(), PaymentFragment())
    var step:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_check_out)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_left_arrow_black_24dp)

        mSteps.add(stepOrder)
        mSteps.add(stepShipment)
        mSteps.add(stepPayment)

        changeStep(step)
        transaction(fragments[step], false, null)
    }

    fun transaction(fragment: Fragment, addToBackStack: Boolean, tag: String?) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        if (addToBackStack && tag != null && step != 0)
            fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
    }

    fun changeStep(currentStep:Int) {
        for(i in mSteps.indices) {
            when {
                i == currentStep -> mSteps[i].setSelected()
                i < currentStep -> mSteps[i].setDone()
                else -> mSteps[i].setUnselected()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        changeStep(--step)
    }
}
