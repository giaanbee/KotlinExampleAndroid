package com.collagemedia.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.collagemedia.kotlinexample.adapter.ListViewAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import com.collagemedia.kotlinexample.sqlite.DataOpenHelper
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_data_sqlite.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.uiThread

class DataSQLiteActivity : AppCompatActivity(), AnkoLogger {
    var dataSQL: DataOpenHelper? = null

    var list: ArrayList<StudentModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_sqlite)

        dataSQL = DataOpenHelper.getInstance(this)

        loadData()

    }

    private fun loadData() {
        async {
            if (dataSQL!!.getCount() == 0){
                for (item in Config.initData())
                    dataSQL!!.addData(item)
            }
            list = dataSQL!!.getAllData()

            uiThread {
                loadComplete()
            }
        }
    }

    private fun loadComplete() {
        tvLoadComplete.visibility = View.GONE
        lvData.adapter = ListViewAdapter(this, R.layout.item_listview, list)
        lvData.setOnItemClickListener { _, _, position, _ ->
            startActivity(intentFor<ViewPagerActivity>("pos" to position))
        }
    }
}
