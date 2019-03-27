package components

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.cloth_io.activities.MainActivity

open class Fragment : Fragment() {

    private var bottomViewPosition:Int = 0
    protected lateinit var mActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as MainActivity
        bottomViewPosition = mActivity.mBottomNav.selectedItemId
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity.mBottomNav.itemTextAppearanceActive = bottomViewPosition
    }
}