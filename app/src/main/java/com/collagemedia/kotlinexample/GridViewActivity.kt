package com.collagemedia.kotlinexample

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
import com.collagemedia.kotlinexample.model.StudentModel
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_gridview.*
import org.jetbrains.anko.AnkoLogger


/*
* Lấy và hiển thị ảnh từ trong 1 folder
* */
class GridViewActivity : AppCompatActivity(), AnkoLogger {
    var lstPhoto: ArrayList<StudentModel>? = null
    val WHAT_GET_ALL_MY_VIDEO_SUCCESS = 100
    val WHAT_GET_ALL_MY_VIDEO_FAILURE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        Config.init(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gridview)
        initView()
    }

    fun initView(): Unit {

        lstPhoto = Config.initData()
        val col = 3
        val pH = Config.SCREENWIDTH / col - (dpToPx(2) * 1);
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, col) as RecyclerView.LayoutManager
        rcGallery.layoutManager = layoutManager
        rcGallery.addItemDecoration(GridSpacingItemDecoration(col, dpToPx(5), true))
        rcGallery.itemAnimator = DefaultItemAnimator()
        rcGallery.adapter = GridViewAdapter(this, lstPhoto!!, pH)
    }

    fun failLoad(): Unit {

    }

    fun dpToPx(dp: Int): Int {
        val r: Resources = resources;
        val px = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
        return px
    }

    inner class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
            val position = parent.getChildAdapterPosition(view) // item position
            val column = position % spanCount // item column
            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing
                }
                outRect.bottom = spacing // item bottom
            } else {
                outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing // item top
                }
            }
        }
    }
}
