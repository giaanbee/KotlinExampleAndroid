package com.collagemedia.kotlinexample

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.adapter.ViewPagerAdapter
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_view_pager.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.info
import org.jetbrains.anko.support.v4.onPageChangeListener

class ViewPagerActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val adapterViewpager = ViewPagerAdapter(this, R.layout.item_pager, Config.initData())
        viewPager.adapter = adapterViewpager

        changeTextCountPager(1, adapterViewpager.count)
        viewPager.onPageChangeListener {
            onPageSelected {
                error { "Page Changing" }
                changeTextCountPager(viewPager.currentItem, adapterViewpager.count)
            }
        }

        val intent = intent
        if (intent != null) {
            val pos = intent.getIntExtra("pos", 0)
            changeTextCountPager(pos, adapterViewpager.count)
            viewPager.currentItem = pos
        }
    }

    fun changeTextCountPager(pos: Int, count: Int) {
        tvCountPager.text = String.format("%2d / %2d", pos + 1, count)
    }
}
