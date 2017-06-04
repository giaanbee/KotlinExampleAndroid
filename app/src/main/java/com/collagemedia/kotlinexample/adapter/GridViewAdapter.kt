package com.collagemedia.kotlinexample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collagemedia.kotlinexample.R
import com.collagemedia.kotlinexample.ViewPagerActivity
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.item_gridview.view.*
import org.jetbrains.anko.intentFor

/*
 * Created by Gia An Bee on 6/3/2017.
 */
class GridViewAdapter(context: Context, data: ArrayList<StudentModel>, pH: Int) : RecyclerView.Adapter<GridViewAdapter.ViewHolderGridView>() {
    var data: ArrayList<StudentModel>
    var context: Context
    var pH: Int

    init {
        this.data = data
        this.context = context
        this.pH = pH
    }

    class ViewHolderGridView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView
        var covervideo: RelativeLayout

        init {
            imgAvatar = itemView.imgItem
            covervideo = itemView.covervideo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, style: Int): ViewHolderGridView {
        val view = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent, false)
        return ViewHolderGridView(view)
    }

    override fun onBindViewHolder(holder: ViewHolderGridView, position: Int) {
        val path = data[position].image;

        holder.covervideo.layoutParams?.height = pH;
        holder.covervideo.layoutParams?.height = pH;
        Glide.with(context)
                .load(path)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgAvatar)
        holder.covervideo.setOnClickListener {
            context.startActivity(context.intentFor<ViewPagerActivity>("pos" to position))
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

}