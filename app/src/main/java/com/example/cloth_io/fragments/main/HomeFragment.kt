package com.example.cloth_io.fragments.main


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.view.*
import com.example.cloth_io.R
import com.example.cloth_io.activities.SellerActivity
import com.example.cloth_io.adapters.SellersAdapter
import com.example.cloth_io.adapters.SliderAdapter
import com.example.cloth_io.api.ApiRequest
import com.example.cloth_io.models.Konveksi
import com.example.cloth_io.others.Dummy
import com.example.cloth_io.others.GridSpacingItemDecoration
import com.google.gson.Gson
import components.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"
    private val gson = Gson()

    private val konveksiList: MutableList<Konveksi> = mutableListOf()
    private lateinit var konveksiAdapter: SellersAdapter

    private val ads_data:MutableList<Int> = arrayListOf(
        R.drawable.banner,
        R.drawable.banner,
        R.drawable.banner,
        R.drawable.banner
    )
    private var currentPage = 0
    private var swipeTimer:Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        fragmentTag = "home"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity.setSupportActionBar(toolbar)
        mActivity.supportActionBar?.title = "Los Intocables"
        mActivity.supportActionBar?.elevation = 0f

        initSlider()

//        konveksiAdapter = SellersAdapter(konveksiList) {
//            startActivity(Intent(context, SellerActivity::class.java))
//        }
        konveksiAdapter = SellersAdapter(Dummy.konveksliList) {
            val intent = Intent(context, SellerActivity::class.java)
            intent.putExtra("konveksi", gson.toJson(it))
            startActivity(intent)
        }
        val decoration = GridSpacingItemDecoration(
            2,
            GridSpacingItemDecoration.dpToPx(12, mActivity),
            true
        )

        hotPreview.setRecyclerView(konveksiAdapter, GridLayoutManager(context, 2), decoration)
        recentPreview.setRecyclerView(konveksiAdapter, GridLayoutManager(context, 2), decoration)

        search_bar.setOnClickListener {
            mActivity.transaction(SearchFragment(), fragmentTag)
        }

        //getData()
        api.get(ApiRequest.konveksi, {
            konveksiList.clear()
            konveksiList.addAll(gson.fromJson(gson.toJson(it.response), Array<Konveksi>::class.java).asList())
            konveksiAdapter.notifyDataSetChanged()
        },{})
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

    private fun initSlider() {
        ads.adapter = SliderAdapter(mActivity, Dummy.bannerList)
        adsIndicator.setupWithViewPager(ads)
    }

    override fun onStart() {
        super.onStart()
        // Auto start of viewpager
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == ads_data.size) {
                currentPage = 0
            }
            ads.setCurrentItem(currentPage++, true)
        }
        swipeTimer = Timer()
        swipeTimer?.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 4000, 4000)
    }

    override fun onStop() {
        super.onStop()
        swipeTimer?.cancel()
        swipeTimer = null
    }
}
