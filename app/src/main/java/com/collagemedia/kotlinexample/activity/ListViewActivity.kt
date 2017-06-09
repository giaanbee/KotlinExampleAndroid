package com.collagemedia.kotlinexample.activity

import com.collagemedia.kotlinexample.R
import org.jetbrains.anko.intentFor

class ListViewActivity : android.support.v7.app.AppCompatActivity(), org.jetbrains.anko.AnkoLogger {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.collagemedia.kotlinexample.R.layout.activity_listview)

        val lstStudent: ArrayList<com.collagemedia.kotlinexample.model.StudentModel> = com.collagemedia.kotlinexample.util.Config.initData()

        kotlinx.android.synthetic.main.activity_listview.lvMain.adapter = com.collagemedia.kotlinexample.adapter.ListViewAdapter(this, R.layout.item_listview, lstStudent)
        kotlinx.android.synthetic.main.activity_listview.lvMain.setOnItemClickListener { _, _, position, _ ->
            startActivity(intentFor<ViewPagerActivity>("pos" to position))
        }
    }
}
