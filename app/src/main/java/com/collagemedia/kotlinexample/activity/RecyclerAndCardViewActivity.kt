package com.collagemedia.kotlinexample.activity

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.collagemedia.kotlinexample.R
import com.collagemedia.kotlinexample.adapter.RecyclerCardViewAdapter
import com.collagemedia.kotlinexample.base.BaseAppcombatActivity
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_recycler_and_card_view.*
import kotlinx.android.synthetic.main.content_recycler_cardview_layout.*


class RecyclerAndCardViewActivity : BaseAppcombatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_and_card_view)
        setSupportActionBar(toolbar)

        initCollapsingToolbar()

        tvCountStudent.text = String.format(getString(R.string.backdrop_subtitle), Config.initData().size)
        val adapter = RecyclerCardViewAdapter(this, Config.initData())

        val mLayoutManager = GridLayoutManager(this, 2)

        recycler_view.layoutManager = mLayoutManager

        recycler_view.addItemDecoration(GridSpacingItemDecoration(2, dpToPx(10), true))
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = adapter

        Glide.with(this).load(R.drawable.cover).into(backdrop)
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    fun initCollapsingToolbar() {
        collapsingToolbar.title = " "
        appbarMain.setExpanded(true)

        // hiding & showing the title when toolbar expanded & collapsed
        appbarMain.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShow = false
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.title = getString(R.string.recycler_cardview)
                    isShow = true
                } else if (isShow) {
                    collapsingToolbar.title = " "
                    isShow = false
                }
            }
        })
    }
}
