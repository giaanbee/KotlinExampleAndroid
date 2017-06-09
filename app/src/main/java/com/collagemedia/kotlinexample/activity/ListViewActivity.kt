package com.collagemedia.kotlinexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.R
import com.collagemedia.kotlinexample.adapter.ListViewAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_listview.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor

class ListViewActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val lstStudent: ArrayList<StudentModel> = Config.initData()

        lvMain.adapter = ListViewAdapter(this, R.layout.item_listview, lstStudent)
        lvMain.setOnItemClickListener { _, _, position, _ ->
            startActivity(intentFor<ViewPagerActivity>("pos" to position))
        }
    }
}
