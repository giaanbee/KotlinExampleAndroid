package com.collagemedia.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.adapter.ListViewAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import com.collagemedia.kotlinexample.sqlite.DataOpenHelper
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_data_sqlite.*
import kotlinx.coroutines.experimental.Deferred
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.custom.async

class DataSQLiteActivity : AppCompatActivity(), AnkoLogger {
    var dataSQL: DataOpenHelper? = null

    var list: ArrayList<StudentModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_sqlite)

        dataSQL = DataOpenHelper.getInstance(this)

//        loadData()

        initView()
    }


    /*--------Using Anko Coroutines--------*/
    fun getData(): ArrayList<StudentModel> {
        var data: ArrayList<StudentModel> = ArrayList()
        if (dataSQL!!.getCount() == 0) {
            for (item in Config.initData())
                dataSQL!!.addData(item)
        }
        data = dataSQL!!.getAllData()
        return data
    }

    fun initView() {
        kotlinx.coroutines.experimental.async(kotlinx.coroutines.experimental.android.UI) {
            val data: Deferred<ArrayList<StudentModel>> = bg {
                // Cha
                getData()
            }

            // This code is executed on the UI thread
            showData(data.await())
        }
    }


    /*-------Normal--------*/
    private fun loadData() {
        async {
            if (dataSQL!!.getCount() == 0) {
                for (item in Config.initData())
                    dataSQL!!.addData(item)
            }
            list = dataSQL!!.getAllData()

            uiThread {
                showData(list)
            }
        }
    }

    private fun showData(data: ArrayList<StudentModel>) {
        lvData.adapter = ListViewAdapter(this, R.layout.item_listview, data)
        lvData.setOnItemClickListener { _, _, position, _ ->
            startActivity(intentFor<ViewPagerActivity>("pos" to position))
        }
    }
}
