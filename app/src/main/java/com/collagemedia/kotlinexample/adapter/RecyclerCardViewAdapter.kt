package com.collagemedia.kotlinexample.adapter

import android.content.Context
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collagemedia.kotlinexample.R
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.cardview_layout.view.*

/*
 * Created by Gia An Bee on 6/9/2017.
 */
class RecyclerCardViewAdapter(context: Context, data: ArrayList<StudentModel>) : RecyclerView.Adapter<RecyclerCardViewAdapter.ViewHolderGridView>() {
    var data: ArrayList<StudentModel>
    var context: Context

    init {
        this.data = data
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolderGridView, position: Int) {
        val path = data[position].image;
        holder.tittle.text = data[position].name
        Glide.with(context)
                .load(path)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.thumbnail)

        holder.overflow.setOnClickListener {
            showPopupMenu(holder.overflow)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolderGridView {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_layout, p0, false)
        return RecyclerCardViewAdapter.ViewHolderGridView(view)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolderGridView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbnail: ImageView
        var overflow: ImageView
        var tittle: TextView

        init {
            thumbnail = itemView.thumbnail
            tittle = itemView.title
            overflow = itemView.overflow
        }
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private fun showPopupMenu(view: View) {
        // inflate menu
        val popup = PopupMenu(context, view)
        val inflater = popup.getMenuInflater()
        inflater.inflate(R.menu.menu_album, popup.getMenu())
        popup.setOnMenuItemClickListener(MyMenuItemClickListener())
        popup.show()
    }


    /**
     * Click listener for popup menu items
     */
    internal inner class MyMenuItemClickListener : PopupMenu.OnMenuItemClickListener {

        override fun onMenuItemClick(menuItem: MenuItem): Boolean {
            when (menuItem.getItemId()) {
                R.id.action_share -> {
                    Toast.makeText(context, "Add to favourite", Toast.LENGTH_SHORT).show()
                    return true
                }
                R.id.action_del -> {
                    Toast.makeText(context, "Play next", Toast.LENGTH_SHORT).show()
                    return true
                }
            }
            return false
        }
    }
}