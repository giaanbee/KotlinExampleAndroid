package com.collagemedia.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.adapter.ListViewAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_listview.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class ListViewActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val lstStudent: ArrayList<StudentModel> = Config.initData()

        lvMain.adapter = ListViewAdapter(this, R.layout.item_listview, lstStudent)
        lvMain.setOnItemClickListener { parent, view, position, id ->
            startActivity(intentFor<ViewPagerActivity>("pos" to position))
        }
    }
}
