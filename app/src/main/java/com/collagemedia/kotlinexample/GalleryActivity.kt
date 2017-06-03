package com.collagemedia.kotlinexample

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View
import com.bumptech.glide.load.engine.Resource
import com.collagemedia.kotlinexample.adapter.GridViewAdapter
import com.collagemedia.kotlinexample.util.Config
import com.collagemedia.kotlinexample.util.FileUtil
import kotlinx.android.synthetic.main.activity_gallery.*
import java.io.File
import java.lang.Exception


/*
* Lấy và hiển thị ảnh từ trong 1 folder
* */
class GalleryActivity : AppCompatActivity() {

    var lstPhoto: ArrayList<String>? = null
    val WHAT_GET_ALL_MY_VIDEO_SUCCESS = 100
    val WHAT_GET_ALL_MY_VIDEO_FAILURE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

    }

    @SuppressLint("HandlerLeak")
    val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                WHAT_GET_ALL_MY_VIDEO_SUCCESS -> initView()
                WHAT_GET_ALL_MY_VIDEO_FAILURE -> failLoad()
            }
        }
    }


    override fun onStart() {
        super.onStart()
        getData()
    }

    fun getData(): Unit {
        Thread(Runnable {
            try {
                val dir = File(FileUtil.getMyAlbum())
                if (dir.isDirectory) {
                    lstPhoto = ArrayList()
                    var children = dir.list()
                    for (i in children.indices) {
                        val childFile = File(dir, children[i])
                        val path: String = childFile.absolutePath
                        lstPhoto!!.add(path)
                    }
                    if (lstPhoto!!.size > 0) {
                        handler.sendEmptyMessage(WHAT_GET_ALL_MY_VIDEO_SUCCESS)
                    } else {
                        handler.sendEmptyMessage(WHAT_GET_ALL_MY_VIDEO_FAILURE)
                    }
                } else {
                    handler.sendEmptyMessage(WHAT_GET_ALL_MY_VIDEO_FAILURE)
                }

            } catch (e: Exception) {
                handler.sendEmptyMessage(WHAT_GET_ALL_MY_VIDEO_FAILURE)
            }
        }).start()
    }

    fun initView(): Unit {
        val col = 1
        val pH = Config.SCREENWIDTH - (dpToPx(5) * 2);

        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, col)
        rcGallery.layoutManager = layoutManager
        rcGallery.addItemDecoration(GridSpacingItemDecoration(col, dpToPx(5), true))
        rcGallery.itemAnimator = DefaultItemAnimator()
        rcGallery.adapter = GridViewAdapter(this, lstPhoto!!)
    }

    fun failLoad(): Unit {

    }

    fun dpToPx(dp: Int): Int {
        var r: Resources = resources;
        var px = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
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
