package com.collagemedia.kotlinexample.adapter

import android.content.ClipData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collagemedia.kotlinexample.R
import kotlinx.android.synthetic.main.item_gridview.view.*

/*
 * Created by Gia An Bee on 6/3/2017.
 */
class GridViewAdapter(context: Context, data: ArrayList<String>) : RecyclerView.Adapter<GridViewAdapter.ViewHolderGridView>() {
    var data: ArrayList<String>? = null
    var context: Context? = null

    init {
        this.data = data
        this.context = context
    }

    class ViewHolderGridView(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView? = null

        init {
            imgAvatar = itemView!!.imgItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, style: Int): ViewHolderGridView {
        val view = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent, false)
        return ViewHolderGridView(view)
    }

    override fun onBindViewHolder(holder: ViewHolderGridView?, position: Int) {
        val path = data!![position];

        Glide.with(context!!)
                .load(path)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder?.imgAvatar)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

}