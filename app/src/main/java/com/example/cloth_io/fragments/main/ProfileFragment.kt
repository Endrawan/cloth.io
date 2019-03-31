package com.example.cloth_io.fragments.main


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cloth_io.R
import com.example.cloth_io.activities.SignInActivity
import com.example.cloth_io.activities.SignUpActivity
import com.example.cloth_io.activities.TransactionActivity
import components.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : Fragment() {

    private val RC_AUTH = 1

    companion object {
        val AUTH_SUCCESS = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentTag = "profile"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signIn.setOnClickListener{
            startActivityForResult(Intent(context, SignInActivity::class.java), RC_AUTH)
        }

        signUp.setOnClickListener {
            startActivityForResult(Intent(context, SignUpActivity::class.java), RC_AUTH)
        }

        menuTrade.setOnClickListener {
            startActivity(Intent(context, TransactionActivity::class.java))
        }

        logout.setOnClickListener{
            mActivity.logout()
            refreshAuth()
        }

        refreshAuth()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            RC_AUTH -> {
                if(resultCode == AUTH_SUCCESS) {
                    mActivity.user = mActivity.getUserFromSP()
                    refreshAuth()
                }
            }
        }
    }

    private fun viewGuest() {
        msgGuest.visibility = View.VISIBLE
        image.visibility = View.GONE
        name.visibility = View.GONE
        location.visibility = View.GONE
        authMenu.visibility = View.VISIBLE
        stats.visibility = View.GONE
        logout.visibility = View.GONE
    }

    private fun viewUser() {
        msgGuest.visibility = View.GONE
        image.visibility = View.VISIBLE
        name.visibility = View.VISIBLE
        location.visibility = View.VISIBLE
        authMenu.visibility = View.GONE
        stats.visibility = View.VISIBLE
        logout.visibility = View.VISIBLE
    }

    private fun refreshAuth() {
        if(mActivity.user != null) viewUser() else viewGuest()
    }

}
