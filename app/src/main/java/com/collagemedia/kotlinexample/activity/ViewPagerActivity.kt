package com.collagemedia.kotlinexample.activity

import com.collagemedia.kotlinexample.R
import com.collagemedia.kotlinexample.util.Config
import org.jetbrains.anko.error

class ViewPagerActivity : android.support.v7.app.AppCompatActivity(), org.jetbrains.anko.AnkoLogger {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.collagemedia.kotlinexample.R.layout.activity_view_pager)

        val adapterViewpager = com.collagemedia.kotlinexample.adapter.ViewPagerAdapter(this, R.layout.item_pager, Config.initData())
        kotlinx.android.synthetic.main.activity_view_pager.viewPager.adapter = adapterViewpager

        changeTextCountPager(1, adapterViewpager.count)
        kotlinx.android.synthetic.main.activity_view_pager.viewPager.onPageChangeListener {
            onPageSelected {
                error { "Page Changing" }
                changeTextCountPager(kotlinx.android.synthetic.main.activity_view_pager.viewPager.currentItem, adapterViewpager.count)
            }
        }

        val intent = intent
        if (intent != null) {
            val pos = intent.getIntExtra("pos", 0)
            changeTextCountPager(pos, adapterViewpager.count)
            kotlinx.android.synthetic.main.activity_view_pager.viewPager.currentItem = pos
        }
    }

    fun changeTextCountPager(pos: Int, count: Int) {
        kotlinx.android.synthetic.main.activity_view_pager.tvCountPager.text = String.format("%2d / %2d", pos + 1, count)
    }
}
