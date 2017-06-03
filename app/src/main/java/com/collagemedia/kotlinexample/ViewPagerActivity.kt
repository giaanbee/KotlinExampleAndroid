package com.collagemedia.kotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.collagemedia.kotlinexample.adapter.ViewPagerAdapter
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        viewPager.adapter = ViewPagerAdapter(this, R.layout.item_pager, Config.initData())
    }
}
