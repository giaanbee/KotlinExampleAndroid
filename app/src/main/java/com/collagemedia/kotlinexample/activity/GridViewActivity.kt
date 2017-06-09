package com.collagemedia.kotlinexample.activity

import kotlinx.android.synthetic.main.activity_gridview.*


/*
* Lấy và hiển thị ảnh từ trong 1 folder
* */
class GridViewActivity : com.collagemedia.kotlinexample.base.BaseAppcombatActivity(), org.jetbrains.anko.AnkoLogger {
    var lstPhoto: ArrayList<com.collagemedia.kotlinexample.model.StudentModel>? = null
    val WHAT_GET_ALL_MY_VIDEO_SUCCESS = 100
    val WHAT_GET_ALL_MY_VIDEO_FAILURE = 101

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        com.collagemedia.kotlinexample.util.Config.init(this)
        super.onCreate(savedInstanceState)
        setContentView(com.collagemedia.kotlinexample.R.layout.activity_gridview)
        initView()
    }

    fun initView(): Unit {

        lstPhoto = com.collagemedia.kotlinexample.util.Config.initData()
        val col = 3
        val pH = com.collagemedia.kotlinexample.util.Config.SCREENWIDTH / col - (dpToPx(2) * 1);
        val layoutManager: android.support.v7.widget.RecyclerView.LayoutManager = android.support.v7.widget.GridLayoutManager(this, col) as android.support.v7.widget.RecyclerView.LayoutManager
       rcGallery.layoutManager = layoutManager
       rcGallery.addItemDecoration(GridSpacingItemDecoration(col, dpToPx(5), true))
       rcGallery.itemAnimator = android.support.v7.widget.DefaultItemAnimator()
       rcGallery.adapter = com.collagemedia.kotlinexample.adapter.GridViewAdapter(this, lstPhoto!!, pH)
    }

    fun failLoad(): Unit {

    }

}
