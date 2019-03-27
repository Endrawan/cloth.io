package com.example.cloth_io.fragments


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.example.cloth_io.R
import com.example.cloth_io.activities.MainActivity
import components.Fragment
import kotlinx.android.synthetic.main.fragment_search.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity.setSupportActionBar(toolbar)
        mActivity.supportActionBar?.setDisplayShowHomeEnabled(true)
        mActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val suggestionsFragment = SearchSuggestionsFragment()
        val autoCompleteFragment = SearchAutoCompleteFragment()
        transaction(suggestionsFragment, false, null)

        search_bar.requestFocusFromTouch()
        search_bar.imeOptions = EditorInfo.IME_ACTION_SEARCH
        search_bar.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard(mActivity)
                (activity as MainActivity).transaction(SearchResultFragment(), true, "search")
            }
            false
        }

        showKeyboard(mActivity)

        search_bar.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if(s.isEmpty()) {
                    transaction(suggestionsFragment, false, null)
                } else {
                    transaction(autoCompleteFragment, false, null)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> {
                hideKeyboard(mActivity)
                mActivity.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun transaction(fragment: Fragment, addToBackStack: Boolean, tag:String?) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        if (addToBackStack && tag != null)
            fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()
        //container.fitsSystemWindows = true
    }

    fun hideKeyboard(context: Context) {
        try {
            (context as Activity).window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
            if (context.currentFocus != null && context.currentFocus!!.windowToken != null) {
                (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                    context.currentFocus!!.windowToken,
                    0
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        mActivity.mBottomNav.visibility = View.VISIBLE
    }

    fun showKeyboard(context: Context) {
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
        mActivity.mBottomNav.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        mActivity.mBottomNav.visibility = View.VISIBLE
    }

}
