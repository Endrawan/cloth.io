package components

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.cloth_io.activities.MainActivity
import com.example.cloth_io.api.ApiRequest

open class Fragment : Fragment() {

    var fragmentTag:String? = null
    private var bottomViewPosition:Int = 0
    protected lateinit var mActivity: MainActivity
    protected lateinit var api:ApiRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as MainActivity
        api = ApiRequest(mActivity)
        bottomViewPosition = mActivity.mBottomNav.selectedItemId
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity.activeTag = fragmentTag
        mActivity.mBottomNav.menu.findItem(bottomViewPosition).isChecked = true
    }

    protected fun toast(text:String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }
}