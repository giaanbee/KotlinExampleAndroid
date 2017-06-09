package com.collagemedia.kotlinexample.activity

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View
import com.collagemedia.kotlinexample.adapter.GridViewAdapter
import com.collagemedia.kotlinexample.base.BaseAppcombatActivity
import com.collagemedia.kotlinexample.model.StudentModel
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_gridview.*
import org.jetbrains.anko.AnkoLogger


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
        kotlinx.android.synthetic.main.activity_gridview.rcGallery.layoutManager = layoutManager
        kotlinx.android.synthetic.main.activity_gridview.rcGallery.addItemDecoration(GridSpacingItemDecoration(col, dpToPx(5), true))
        kotlinx.android.synthetic.main.activity_gridview.rcGallery.itemAnimator = android.support.v7.widget.DefaultItemAnimator()
        kotlinx.android.synthetic.main.activity_gridview.rcGallery.adapter = com.collagemedia.kotlinexample.adapter.GridViewAdapter(this, lstPhoto!!, pH)
    }

    fun failLoad(): Unit {

    }

}
