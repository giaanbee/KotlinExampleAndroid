package com.collagemedia.kotlinexample.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.item_pager.view.*


/*
 * Created by Gia An Bee on 6/3/2017.
 */
class ViewPagerAdapter(context: Context, resource: Int, data: ArrayList<StudentModel>) : PagerAdapter() {
    var data: ArrayList<StudentModel>? = null
    var iResource: Int
    var iInflate: LayoutInflater
    var context: Context

    init {
        this.context = context
        this.data = data
        this.iResource = resource
        this.iInflate = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun isViewFromObject(p0: View?, p1: Any): Boolean {
        return p0 == p1
    }

    override fun instantiateItem(parent: ViewGroup, position: Int): View {
        val retView: View = iInflate.inflate(iResource, null)
        retView.imgItem.setImage(data!![position].image, context)
        parent.addView(retView)
        return retView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    fun ImageView.setImage(url: Int, context: Context) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this)
    }

    override fun getCount() = data!!.size
}