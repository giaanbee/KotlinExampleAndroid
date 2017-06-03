package com.collagemedia.kotlinexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.student_item_layout.view.*

/*
 * Created by Gia An Bee on 6/2/2017.
 */
open class ListStudentAdapter(context: Context, resource: Int, data: ArrayList<StudentModel>) : ArrayAdapter<StudentModel>(context, resource, data) {
    var iResource: Int
    var iData: ArrayList<StudentModel>
    var iInflate: LayoutInflater

    init {
        this.iResource = resource
        this.iData = data
        this.iInflate = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount() = iData.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val retView: View?

        if (convertView == null) {
            retView = iInflate.inflate(iResource, null)
            holder = ViewHolder()
            holder.imgAvatar = retView?.imgAvatar
            holder.tvName = retView?.tvName
            holder.tvBirthday = retView?.tvBirthday

            retView?.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            retView = convertView
        }
        val student = iData[position]
        holder.tvName?.text = student.name
        holder.tvBirthday?.text = student.birthday
        holder.imgAvatar?.setImage(student.url, context)
        return retView!!
    }

    fun ImageView.setImage(url: String, context: Context) {
        Glide.with(context)
                .load(url)
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this)
    }

    class ViewHolder {
        var imgAvatar: ImageView? = null
        var tvName: TextView? = null
        var tvBirthday: TextView? = null
    }

}