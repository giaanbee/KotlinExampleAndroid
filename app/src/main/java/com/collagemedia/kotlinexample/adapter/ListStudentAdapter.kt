package com.collagemedia.kotlinexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collagemedia.kotlinexample.R
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.student_item_layout.view.*

/*
 * Created by Gia An Bee on 6/2/2017.
 */
class ListStudentAdapter(context: Context, var resource: ArrayList<StudentModel>) : ArrayAdapter<StudentModel>(context, R.layout.student_item_layout, resource) {
    override fun getCount() = resource.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val row = LayoutInflater.from(context).inflate(R.layout.student_item_layout, parent, false)
        val student = resource[position]
        row.tvName.text = student.name
        row.tvBirthday.text = student.birthday
        row.imgAvatar.setImage(student.url, context)
        return row
    }

    fun ImageView.setImage(url: String, context: Context) {
        Glide.with(context)
                .load(url)
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this)
    }
}